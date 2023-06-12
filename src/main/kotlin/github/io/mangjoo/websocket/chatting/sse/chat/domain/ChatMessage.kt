package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.domain.vo.Sender
import java.util.*

data class ChatMessage(
    val id: Long,
    val chatRoomId: UUID,
    val sender: Sender,
    val message: String
) {
    init {
        require(message.isNotBlank()) { "message must not be blank" }
    }
    constructor(chatRoomId: UUID, sender: String, message: String) : this(
        0,
        chatRoomId,
        Sender(sender),
        message
    )

    fun autoId(id: Long) = ChatMessage(
        id,
        chatRoomId,
        sender,
        message
    )
}
