package github.io.mangjoo.websocket.chatting.sse.user.domain

import github.io.mangjoo.websocket.chatting.sse.user.application.ChatUserMemoryRepository
import org.springframework.stereotype.Repository
import java.util.*

interface UserRepository {
    fun save(user: User): User
//    fun findByEmitter(emitter: SseEmitter): User
    fun findById(id: UUID): User

    @Repository
    class UserRepositoryImpl(
        private val memoryRepository: ChatUserMemoryRepository
    ) : UserRepository {
        override fun save(user: User): User = memoryRepository.save(user)
//        override fun findByEmitter(emitter: SseEmitter): User = memoryRepository.findByEmitter(emitter)
        override fun findById(id: UUID): User = memoryRepository.findById(id)
    }
}