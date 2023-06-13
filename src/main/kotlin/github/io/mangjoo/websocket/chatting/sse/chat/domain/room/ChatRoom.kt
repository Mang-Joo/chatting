package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import java.util.*

data class ChatRoom(
    val id: UUID = UUID.randomUUID(),
    val roomName: String,
    val users: List<UUID> = mutableListOf(),
) {
    companion object {
        fun createRoom(roomName: String, userId: UUID) = ChatRoom(
            roomName = roomName,
            users = listOf(userId)
        )
    }

    fun add(userId: UUID) = ChatRoom(
        id,
        roomName,
        users.plusElement(userId)
    )

    fun outChatUser(userId: UUID) = ChatRoom(
        id,
        roomName,
        users.minusElement(userId)
    )

    val numberOfPeople get() = users.size
}