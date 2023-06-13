package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import java.util.UUID

interface JoinChatRoomUseCase {
    fun join(chatId: UUID, userId: UUID): JoinRoomResponse
}