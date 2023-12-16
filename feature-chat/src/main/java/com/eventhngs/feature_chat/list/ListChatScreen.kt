package com.eventhngs.feature_chat.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_chat.component.ChatListItem
import com.eventhngs.feature_chat.component.ChatSearchBar
import com.eventhngs.feature_chat.component.EmptyChatContent
import com.eventhngs.feature_chat.domain.ChatList
import com.eventhngs.ui.component.topappbar.BaseTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun ListChatScreen(
    modifier: Modifier = Modifier,
    navigateToChatDetailScreen: (Int) -> Unit = {}
) {

    var query by remember { mutableStateOf("") }
    val chats = remember {
        (1..10).map {
            ChatList(
                id = it,
                photo = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg    ",
                name = "Magang Update",
                lastChat = "Lorem ipsum dolor sit amet, consectetur adipiscin"
            )
        }
    }

    Scaffold(
        topBar = {
            BaseTopAppBar(title = "Chats")
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
        ) {
            item {
                ChatSearchBar(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = "Search",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            if (chats.isEmpty()) {
                item {
                    EmptyChatContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 174.dp)
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(10.dp)) }
            items(items = chats, key = { it.id }) { chatList ->
                ChatListItem(
                    chatList = chatList,
                    onClick = { navigateToChatDetailScreen(it.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewListChatScreen() {
    EventhngsTheme {
        Surface {
            ListChatScreen()
        }
    }
}
