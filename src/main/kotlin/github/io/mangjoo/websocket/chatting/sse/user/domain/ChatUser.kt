package github.io.mangjoo.websocket.chatting.sse.user.domain

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

data class ChatUser(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val sseEmitter: SseEmitter? = null
) {
    init {
        require(name.isNotBlank()) { "name must not be blank" }
    }
    fun join(sseEmitter: SseEmitter) = ChatUser(id, name, sseEmitter)
}