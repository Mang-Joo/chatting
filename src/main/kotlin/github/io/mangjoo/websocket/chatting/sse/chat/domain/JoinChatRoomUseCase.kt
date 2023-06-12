package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import java.util.*

interface JoinChatRoomUseCase {
    fun join(chatId: UUID, userId: UUID): JoinRoomResponse
}