package com.eventhngs.feature_chat.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import com.eventhngs.feature_chat.component.ChatBubble
import com.eventhngs.feature_chat.component.ChatBubbleType
import com.eventhngs.feature_chat.component.ChatDateDivider
import com.eventhngs.feature_chat.component.ChatItem
import com.eventhngs.feature_chat.component.EmptyChatConversation
import com.eventhngs.feature_chat.component.isMe
import com.eventhngs.feature_chat.domain.DetailChatHeader
import com.eventhngs.ui.component.textfield.ChatTextField
import com.eventhngs.ui.component.topappbar.DetailChatTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun DetailChatScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    chatId: String = ""
) {

    val userId = "user123"
    var message by remember { mutableStateOf("") }

    val chatInfo by remember {
        mutableStateOf(DetailChatHeader(
            photo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
            name = "Magang Update",
            type = "Sponsor",
            tagline = "in goals to ingnite 1000+ startup in Indonesia every year."
        ))
    }

    val chats = listOf(
        ChatItem(
            id = "948024fwew",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "4829038402hfuefhe",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "9480241fwew",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "4829038402h2fuefhe",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "94802453fwew",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "482903538402hfuefhe",
            userId = userId,
            date = "12 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
        ChatItem(
            id = "845902342hfwerufhe",
            userId = "sponsor123",
            date = "13 September 2023",
            time = "13:59",
            text = "Hi, 100 Startup digital, currently I’m looking for sponsorship for a startup, are you available?"
        ),
    )
    val chatGrouped = remember(key1 = chats) {
        chats.groupBy { it.date }
    }

    Scaffold(
        topBar = {
            DetailChatTopAppBar(
                image = chatInfo.photo,
                title = chatInfo.name,
                subtitle = chatInfo.type,
                modifier = Modifier.statusBarsPadding(),
                onNavigationClick = navigateUp
            )
        },
        bottomBar = {
            ChatTextField(
                value = message,
                onValueChange = { message = it },
                placeholder = "Write your message",
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 12.dp, horizontal = 20.dp)
            )
        },
        modifier = modifier.safeDrawingPadding()
            .imePadding()
            .imeNestedScroll()
    ) { paddingValues ->
        if (chats.isEmpty()) {
            EmptyChatConversation(
                info = chatInfo,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            chatGrouped.forEach { (date, chats) ->
                stickyHeader {
                    ChatDateDivider(
                        date = date,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                itemsIndexed(items = chats, key = { _ , chat -> chat.id }) { index, chat ->
                    val chatBubbleType = if (chat.isMe(userId)) ChatBubbleType.Mine
                    else ChatBubbleType.YOUR
                    val showLabel = if (index != 0) {
                        val preChat = chats[index]
                        chat.userId != preChat.userId
                    } else true
                    ChatBubble(
                        name = chatInfo.name,
                        photo = chatInfo.photo,
                        chat = chat,
                        type = chatBubbleType,
                        showLabel = showLabel,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewDetailChatScreen() {
    EventhngsTheme {
        Surface {
            DetailChatScreen()
        }
    }
}
