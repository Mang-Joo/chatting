package github.io.mangjoo.websocket.chatting.sse.user.application

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
import org.springframework.stereotype.Repository
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Repository
class ChatUserMemoryRepository {
    val users: MutableList<ChatUser> = mutableListOf()

    fun save(chatUser: ChatUser): ChatUser = chatUser
        .apply { users.add(this) }

    fun findByEmitter(sseEmitter: SseEmitter): ChatUser = users
        .first { it.sseEmitter == sseEmitter }

    fun findById(id: UUID): ChatUser = users.first { it.id == id }
}
