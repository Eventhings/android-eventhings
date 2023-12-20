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
    navigateToChatDetailScreen: (String) -> Unit = {}
) {

    var query by remember { mutableStateOf("") }
    val chats = remember {
        listOf(
            ChatList(
                id = "1",
                photo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg    ",
                name = "Magang Update",
                lastChat = "Hi, Magang Update, currently I’m looking for sponsorship for a startup, are you available?"
            ),
            ChatList(
                id = "2",
                photo = "https://play-lh.googleusercontent.com/pmh5szForuPHhODR8NreJwujicywqb7PY1Kf66jyHO9qkEbbnSR_r9eVuo5ZdHWHwg=w240-h480-rw    ",
                name = "1000 Startup Digital",
                lastChat = "Hi! yes we are actually open for sponsoship"
            ),
        )
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
