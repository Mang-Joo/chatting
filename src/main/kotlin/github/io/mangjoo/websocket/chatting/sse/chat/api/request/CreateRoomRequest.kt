package github.io.mangjoo.websocket.chatting.sse.chat.api.request

import java.util.UUID

data class CreateRoomRequest(
    val userId: String,
    val roomName: String,
) {
    val userIdToUUID get() = UUID.fromString(userId)
}
