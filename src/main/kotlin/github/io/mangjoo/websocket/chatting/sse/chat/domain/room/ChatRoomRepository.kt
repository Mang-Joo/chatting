package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import github.io.mangjoo.websocket.chatting.sse.chat.application.repository.ChatRoomMemoryRepository
import org.springframework.stereotype.Repository
import java.util.*

interface ChatRoomRepository {
    fun addChatUser(chatId: UUID, userId: UUID): ChatRoom
    fun findByChatId(chatId: UUID): ChatRoom
    fun remove(chatId: UUID, chatUser: UUID): ChatRoom
    fun save(chatRoom: ChatRoom): ChatRoom

    @Repository
    class ChatRoomRepositoryImpl(
        private val memoryRepository: ChatRoomMemoryRepository,
    ) : ChatRoomRepository {
        override fun addChatUser(chatId: UUID, userId: UUID) = memoryRepository
            .findByChatId(chatId)
            .apply { add(userId) }
            .let { memoryRepository.save(it) }

        override fun findByChatId(chatId: UUID): ChatRoom = memoryRepository
            .findByChatId(chatId)

        override fun remove(chatId: UUID, chatUser: UUID): ChatRoom {
            TODO("Not yet implemented")
        }

        override fun save(chatRoom: ChatRoom): ChatRoom = memoryRepository
            .let { memoryRepository.save(chatRoom) }
    }

}