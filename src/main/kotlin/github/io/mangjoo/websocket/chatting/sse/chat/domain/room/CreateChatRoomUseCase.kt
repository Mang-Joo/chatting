package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.CreateRoomResponse
import java.util.UUID

interface CreateChatRoomUseCase {
    fun create(roomName: String, userId: UUID): CreateRoomResponse
}