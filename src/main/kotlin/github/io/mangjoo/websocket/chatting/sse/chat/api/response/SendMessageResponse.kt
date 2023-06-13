package github.io.mangjoo.websocket.chatting.sse.chat.api.response

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom

data class SendMessageResponse(
    val chatId: java.util.UUID,
    val chatRoomName: String,
    val sender: String,
    val message: String,
) {
    companion object {
        fun of(ChatRoom: ChatRoom, sender: String, message: String) = SendMessageResponse(
            chatId = ChatRoom.id,
            chatRoomName = ChatRoom.roomName,
            sender = sender,
            message = message
        )
    }
}
