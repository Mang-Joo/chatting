package github.io.mangjoo.websocket.chatting.sse.chat.domain.message

import github.io.mangjoo.websocket.chatting.sse.chat.domain.vo.Sender
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*

data class ChatMessage(
    val id: UUID = UUID.randomUUID(),
    val chatRoomId: UUID,
    val sender: Sender,
    val message: String,
    val createdAt: LocalDateTime = now(),
) {
    init {
        require(message.isNotBlank()) { "message must not be blank" }
    }

    constructor(chatRoomId: UUID, sender: String, message: String) : this(
        chatRoomId = chatRoomId,
        sender = Sender(sender),
        message = message
    )
}
