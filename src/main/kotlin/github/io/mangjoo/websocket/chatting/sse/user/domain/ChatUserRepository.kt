package github.io.mangjoo.websocket.chatting.sse.user.domain

import github.io.mangjoo.websocket.chatting.sse.user.application.ChatUserMemoryRepository
import org.springframework.stereotype.Repository
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

interface ChatUserRepository {
    fun save(chatUser: ChatUser): ChatUser
    fun findByEmitter(emitter: SseEmitter): ChatUser
    fun findById(id: UUID): ChatUser

    @Repository
    class ChatUserRepositoryImpl(
        private val memoryRepository: ChatUserMemoryRepository
    ) : ChatUserRepository {
        override fun save(chatUser: ChatUser): ChatUser = memoryRepository.save(chatUser)
        override fun findByEmitter(emitter: SseEmitter): ChatUser = memoryRepository.findByEmitter(emitter)
        override fun findById(id: UUID): ChatUser = memoryRepository.findById(id)
    }
}