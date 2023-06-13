package github.io.mangjoo.websocket.chatting.sse.chat.api.response

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom

data class JoinRoomResponse(
    val chatId: java.util.UUID,
    val chatRoomName: String,
    val name: String,
    val message: String,
) {
    companion object {
        fun of(ChatRoom: ChatRoom, userName: String) = JoinRoomResponse(
            ChatRoom.id,
            ChatRoom.roomName,
            userName,
            "Welcome to $ChatRoom.name, $userName!"
        )
    }
}