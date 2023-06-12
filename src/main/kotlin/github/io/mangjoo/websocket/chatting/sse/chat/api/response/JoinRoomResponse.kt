package github.io.mangjoo.websocket.chatting.sse.chat.api.response

import github.io.mangjoo.websocket.chatting.sse.chat.domain.ChatRoom
import java.util.*

data class JoinRoomResponse(
    val chatId: UUID,
    val chatRoomName: String,
    val name: String,
    val message: String,
) {
    companion object {
        fun of(chatRoom: ChatRoom, userName: String) = JoinRoomResponse(
            chatRoom.id,
            chatRoom.roomName,
            userName,
            "Welcome to $chatRoom.name, $userName!"
        )
    }
}