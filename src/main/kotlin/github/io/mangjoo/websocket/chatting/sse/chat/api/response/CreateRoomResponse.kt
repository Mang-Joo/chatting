package github.io.mangjoo.websocket.chatting.sse.chat.api.response

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import java.util.UUID

data class CreateRoomResponse(
    val roomId: UUID,
    val roomName: String,
    val numberOfPeople: Int,
) {
    companion object {
        fun of(chatRoom: ChatRoom) = CreateRoomResponse(
            roomId = chatRoom.id,
            roomName = chatRoom.roomName,
            numberOfPeople = chatRoom.numberOfPeople
        )
    }
}
