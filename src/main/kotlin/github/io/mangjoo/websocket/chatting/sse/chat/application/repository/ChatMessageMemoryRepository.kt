package github.io.mangjoo.websocket.chatting.sse.chat.application.repository

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ChatMessageMemoryRepository {
    private val chatMessages: MutableList<ChatMessage> = mutableListOf()

    fun save(chatMessage: ChatMessage): ChatMessage = chatMessages.plusElement(chatMessage)
        .let { chatMessage }

    fun findAllByChatRoomId(chatRoomId: UUID): List<ChatMessage> = chatMessages
        .filter { it.chatRoomId == chatRoomId }
        .toList()
}
