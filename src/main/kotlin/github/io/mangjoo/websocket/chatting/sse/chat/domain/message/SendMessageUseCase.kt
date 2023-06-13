package github.io.mangjoo.websocket.chatting.sse.chat.domain.message

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.SendMessageResponse
import java.util.*

interface SendMessageUseCase {
    fun sendMessage(chatId: UUID, userId: UUID, message: String): SendMessageResponse
}