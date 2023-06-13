package github.io.mangjoo.websocket.chatting.sse.chat.domain.message

import org.springframework.stereotype.Repository

interface ChatMessageRepository {
    fun save(chatMessage: ChatMessage): ChatMessage
//    fun findAllByChatRoomId(chatRoomId: UUID): List<ChatMessage>

    @Repository
    class ChatMessageRepositoryImpl(
        private val chatMessages: MutableList<ChatMessage> = mutableListOf(),
    ) : ChatMessageRepository {

        override fun save(chatMessage: ChatMessage): ChatMessage = chatMessages.plusElement(chatMessage)
            .let { chatMessage }

    }
}