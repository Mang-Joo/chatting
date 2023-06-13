package github.io.mangjoo.websocket.chatting.sse.chat.api.response

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import java.util.*

data class SendMessageResponse(
    val chatId: UUID,
    val chatRoomName: String,
    val sender: String,
    val message: String,
) {
    companion object {
        fun of(chatRoom: ChatRoom, sender: String, message: String) = SendMessageResponse(
            chatId = chatRoom.id,
            chatRoomName = chatRoom.roomName,
            sender = sender,
            message = message
        )
    }
}
