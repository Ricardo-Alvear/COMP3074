package ca.gbc.comp3074.labex4

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

import ca.gbc.comp3074.labex4.sqlitecompose.data.AppDatabase
import ca.gbc.comp3074.labex4.sqlitecompose.ui.CustomerScreen
import ca.gbc.comp3074.labex4.sqlitecompose.ui.CustomerViewModel
import ca.gbc.comp3074.labex4.sqlitecompose.ui.CustomerViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Room Database Singleton
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