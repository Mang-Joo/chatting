package github.io.mangjoo.websocket.chatting.sse.user.application

import github.io.mangjoo.websocket.chatting.sse.user.domain.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ChatUserMemoryRepository {
    val users: MutableList<User> = mutableListOf()

    fun save(chatUser: User): User = chatUser
        .apply { users.add(this) }

//    fun findByEmitter(sseEmitter: SseEmitter): User = users
//        .first { it.sseEmitter == sseEmitter }

    fun findById(id: UUID): User = users.first { it.id == id }
}
