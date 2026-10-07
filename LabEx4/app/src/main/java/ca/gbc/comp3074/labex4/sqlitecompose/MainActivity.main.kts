package com.example.sqlitecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sqlitecompose.data.AppDatabase
import com.example.sqlitecompose.ui.CustomerApp
import com.example.sqlitecompose.ui.CustomerScreen
import com.example.sqlitecompose.ui.CustomerViewModel
import com.example.sqlitecompose.ui.CustomerViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: CustomerViewModel = viewModel(
                        factory = CustomerViewModelFactory(database.customerDao())
                    )

                    CustomerApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CustomerApp(
    viewModel: CustomerViewModel
) {
    val customers by viewModel.customers.collectAsStateWithLifecycle(initialValue = emptyList())

    CustomerScreen(
        customers = customers,
        onAddCustomer = viewModel::addCustomer,
        onDeleteCustomer = viewModel::deleteCustomer,
        onSearchQueryChange = viewModel::setSearchQuery
    )
}