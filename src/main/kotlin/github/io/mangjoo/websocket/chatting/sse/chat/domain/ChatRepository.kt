package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.application.repository.ChatRoomMemoryRepository
import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
import org.springframework.stereotype.Repository
import java.util.*

interface ChatRepository {
    fun addChatUser(chatId: UUID, chatUser: ChatUser): ChatRoom
    fun findByChatId(chatId: UUID): ChatRoom
    fun remove(chatId: UUID, chatUser: ChatUser): ChatUser

    @Repository
    class ChatRepositoryImpl(
        private val memoryRepository: ChatRoomMemoryRepository
    ) : ChatRepository {
        override fun addChatUser(chatId: UUID, chatUser: ChatUser) = memoryRepository
            .findByChatId(chatId)
            .apply { chatUsers.add(chatUser) }
            .let { memoryRepository.save(it) }

        override fun findByChatId(chatId: UUID): ChatRoom = memoryRepository
            .findByChatId(chatId)

        override fun remove(chatId: UUID, chatUser: ChatUser): ChatUser {
            TODO("Not yet implemented")
        }
    }

}