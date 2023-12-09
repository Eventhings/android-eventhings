package com.eventhngs.feature_chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.feature_chat.domain.ChatList
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun ChatListItem(
    modifier: Modifier = Modifier,
    chatList: ChatList,
    onClick: (ChatList) -> Unit = {}
) {
    Row(
        modifier = Modifier.clickable { onClick(chatList) }
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = chatList.photo,
            contentDescription = chatList.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .shadow(elevation = 2.dp, shape = CircleShape)
                .clip(CircleShape)
                .size(55.dp)
                .background(MaterialTheme.colorScheme.background)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = chatList.name,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF2D2D2D),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = chatList.lastChat,
                fontSize = 11.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFF404040),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewChatListItem() {
    EventhngsTheme {
        Surface {
            val chatList = ChatList(
                id = 1,
                photo = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg    ",
                name = "Magang Update",
                lastChat = "Lorem ipsum dolor sit amet, consectetur adipiscin"
            )
            ChatListItem(
                chatList = chatList,
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
