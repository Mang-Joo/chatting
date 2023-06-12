package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUsers
import java.util.*

data class ChatRoom(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val chatUsers: ChatUsers
) {
    fun add(chatUser: ChatUser) = chatUsers.add(chatUser)
}