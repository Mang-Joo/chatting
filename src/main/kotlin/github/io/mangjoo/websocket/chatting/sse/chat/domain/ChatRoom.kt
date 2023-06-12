package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUsers
import java.util.*

data class ChatRoom(
    val id: UUID = UUID.randomUUID(),
    val roomName: String,
    val chatUsers: ChatUsers = ChatUsers()
) {
    fun add(chatUser: ChatUser) = ChatRoom(
        id,
        roomName,
        chatUsers.add(chatUser)
    )

    val numberOfPeople get() = chatUsers.size
}