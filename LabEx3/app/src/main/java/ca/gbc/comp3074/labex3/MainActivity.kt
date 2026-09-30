package ca.gbc.comp3074.labex3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ca.gbc.comp3074.labex3.ui.theme.LabEx3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sampleMessages = listOf(
            Message(1, "Joe", "Hi!"),
            Message(2, "Jim", "How are you?"),
            Message(3, "Joe", "Test..1..2...3"),
            Message(4, "Joe", "I hate coding!!!"),
            Message(5, "Joe", "Hi!"),
            Message(6, "Jim", "How are you?"),
            Message(7, "Joe", "Test..1..2...3"),
            Message(8, "Joe", "I hate coding!!!"),
            Message(9, "Joe", "Hi!"),
            Message(10, "Jim", "How are you?"),
            Message(11, "Joe", "Test..1..2...3"),
            Message(12, "Joe", "I hate coding!!!")
        )

        setContent {
            LabEx3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChatScreen(
                        messages = sampleMessages,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}