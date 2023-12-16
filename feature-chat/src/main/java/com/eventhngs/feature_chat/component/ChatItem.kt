package com.eventhngs.feature_chat.component

data class ChatItem(
    val id: String,
    val userId: String,
    val date: String,
    val time: String,
    val text: String
)

fun ChatItem.isMe(userId: String): Boolean = userId == this.userId
