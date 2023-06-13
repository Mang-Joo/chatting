package github.io.mangjoo.websocket.chatting.sse.chat.domain.message

import github.io.mangjoo.websocket.chatting.sse.chat.application.repository.ChatMessageMemoryRepository
import org.springframework.stereotype.Repository
import java.util.*

interface ChatMessageRepository {
    fun save(chatMessage: ChatMessage): ChatMessage
    fun findAllByChatRoomId(chatRoomId: UUID): List<ChatMessage>

    @Repository
    class ChatMessageRepositoryImpl(
        private val chatMessageMemoryRepository: ChatMessageMemoryRepository
    ) : ChatMessageRepository {

        override fun save(chatMessage: ChatMessage): ChatMessage = chatMessageMemoryRepository.save(chatMessage)

        override fun findAllByChatRoomId(chatRoomId: UUID): List<ChatMessage> = chatMessageMemoryRepository
            .findAllByChatRoomId(chatRoomId)

    }
}