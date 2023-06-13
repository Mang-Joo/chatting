package github.io.mangjoo.websocket.chatting.sse.chat.domain.message

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.SendMessageResponse
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import java.util.UUID

interface SendMessageUseCase {
    fun sendMessage(chatRoomId: UUID, userId: java.util.UUID, message: String): SendMessageResponse
}