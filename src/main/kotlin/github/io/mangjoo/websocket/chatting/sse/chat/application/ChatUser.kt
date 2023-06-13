package github.io.mangjoo.websocket.chatting.sse.chat.application

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

data class ChatUser(
    val userId: UUID,
    val sseEmitter: SseEmitter? = null,
) {


    fun join(sseEmitter: SseEmitter) = ChatUser(userId, sseEmitter)

    fun sendChatUser(message: ChatMessage) = sseEmitter
        ?.send(event(message))
        ?.let { ChatUser(userId, sseEmitter) } ?: throw IllegalStateException("Not connected sse")

    private fun event(message: ChatMessage): MutableSet<ResponseBodyEmitter.DataWithMediaType> = SseEmitter
        .event()
        .name("message")
        .data(message)
        .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatUser

        return userId == other.userId
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }


}