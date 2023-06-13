package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import java.util.*

data class ChatRoom(
    val id: UUID = UUID.randomUUID(),
    val roomName: String,
    val chatUsers: List<UUID> = mutableListOf(),
    val messages: List<UUID> = mutableListOf(),
) {
    fun add(userId: UUID) = ChatRoom(
        id,
        roomName,
        chatUsers.plusElement(userId)
    )

    fun outChatUser(userId: UUID) = ChatRoom(
        id,
        roomName,
        chatUsers.minusElement(userId)
    )

    fun sendMessage(messageId: UUID) = ChatRoom(
        id,
        roomName,
        chatUsers,
        messages.plusElement(messageId)
    )

    val messageCount get() = messages.size

    val numberOfPeople get() = chatUsers.size
}