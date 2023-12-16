package com.eventhngs.feature_chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

enum class ChatBubbleType {
    Mine, YOUR
}

@Composable
fun ChatBubble(
    modifier: Modifier = Modifier,
    name: String,
    photo: String,
    showLabel: Boolean = false,
    chat: ChatItem,
    type: ChatBubbleType = ChatBubbleType.Mine
) {
    when (type) {
        ChatBubbleType.Mine -> MineChatBubble(
            modifier, chat, showLabel
        )
        ChatBubbleType.YOUR -> YourChatBubble(
            modifier,
            name,
            photo,
            showLabel,
            chat
        )
    }
}

@Composable
private fun MineChatBubble(
    modifier: Modifier = Modifier,
    chat: ChatItem,
    showLabel: Boolean = false
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        if (showLabel) {
            Text(
                text = "You",
                fontSize = 10.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA4A4A4)
            )
        }
        Text(
            text = chat.text,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF000000),
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 16.dp
                    )
                )
                .background(Color(0xFFF6F6F6))
                .padding(horizontal = 10.dp, vertical = 8.dp)
        )
        Text(
            text = chat.time,
            fontSize = 10.sp,
            lineHeight = 16.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFFA4A4A4),
            textAlign = TextAlign.Right,
        )
    }
}

@Composable
private fun YourChatBubble(
    modifier: Modifier = Modifier,
    name: String,
    photo: String,
    showLabel: Boolean = false,
    chat: ChatItem
) {
    Row(modifier = modifier.fillMaxWidth(.9f)) {
        AsyncImage(
            model = photo,
            contentDescription = name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.Start) {
            if (showLabel) {
                Text(
                    text = name,
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFA4A4A4),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Text(
                text = chat.text,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFF000000),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp,
                            bottomStart = 0.dp
                        )
                    )
                    .background(Color(0xFFF5EEFF))
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            )
            Text(
                text = chat.time,
                fontSize = 10.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFFA4A4A4),
                textAlign = TextAlign.Right,
            )
        }
    }
}


@Preview
@Composable
fun PreviewMineChatBubble() {
    EventhngsTheme {
        Surface {
            val chat = ChatItem(
                id = "948024fwew",
                userId = "userId",
                date = "12 September 2023",
                time = "13:59",
                text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
            )
            MineChatBubble(
                chat = chat,
                showLabel = true,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewYourChatBubble() {
    EventhngsTheme {
        Surface {
            val chat = ChatItem(
                id = "948024fwew",
                userId = "userId",
                date = "12 September 2023",
                time = "13:59",
                text = "Hi, 100 Startup digital"
            )
            YourChatBubble(
                name = "100 Startup Digital",
                photo = "",
                chat = chat,
                showLabel = true,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
