package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import github.io.mangjoo.websocket.chatting.sse.chat.application.repository.ChatRoomMemoryRepository
import org.springframework.stereotype.Repository

interface ChatRoomRepository {
    fun addChatUser(chatRoomId: java.util.UUID, userId: java.util.UUID): ChatRoom
    fun findByChatRoomId(chatRoomId: java.util.UUID): ChatRoom
    fun remove(chatRoomId: java.util.UUID, chatUser: java.util.UUID): ChatRoom
    fun save(chatRoom: ChatRoom): ChatRoom

    @Repository
    class ChatRoomRepositoryImpl(
        private val memoryRepository: ChatRoomMemoryRepository,
    ) : ChatRoomRepository {
        override fun addChatUser(chatRoomId: java.util.UUID, userId: java.util.UUID) = memoryRepository
            .findByChatId(chatRoomId)
            .apply { add(userId) }
            .let { memoryRepository.save(it) }

        override fun findByChatRoomId(chatRoomId: java.util.UUID): ChatRoom = memoryRepository
            .findByChatId(chatRoomId)

        override fun remove(chatRoomId: java.util.UUID, chatUser: java.util.UUID): ChatRoom {
            TODO("Not yet implemented")
        }

        override fun save(chatRoom: ChatRoom): ChatRoom = memoryRepository
            .let { memoryRepository.save(chatRoom) }
    }

}