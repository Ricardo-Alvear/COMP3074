package ca.gbc.comp3074.labex3

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data model representing a chat message
data class Message(
    val id: Int,
    val sender: String,
    val text: String
)

@Composable
fun ChatScreen(
    messages: List<Message>,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFFAF5FA) // Very light pinkish-white background
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = messages,
                key = { message -> message.id }
            ) { message ->
                ChatMessageItem(message = message)
            }
        }
    }
}

@Composable
fun ChatMessageItem(
    message: Message,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        // Avatar circle with red border and grey icon
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(Color.White)
                .border(2.dp, Color(0xFFD32F2F), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Avatar",
                tint = Color.LightGray,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Message content
        Column {
            Text(
                text = message.sender,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4A4A4A)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 0.5.dp
            ) {
                Text(
                    text = message.text,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
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

    ChatScreen(messages = sampleMessages)
}