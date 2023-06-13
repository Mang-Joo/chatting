package github.io.mangjoo.websocket.chatting.sse.chat.application.repository

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import org.springframework.stereotype.Repository
import java.util.*

var CHAT_MESSAGE_ID = 1L

@Repository
class ChatRoomMemoryRepository(
    private val chatRooms: MutableList<ChatRoom> = mutableListOf(),
) {
    fun save(
        chatRoom: ChatRoom,
    ): ChatRoom = when (chatRooms.find { it == chatRoom }) {
        null -> chatRoom.apply { chatRooms.add(this) }
        else -> chatRoom.also { chatRooms.remove(it) }
            .also { chatRooms.add(it) }
    }

    fun findByChatId(chatId: UUID): ChatRoom = chatRooms.first { it.id == chatId }
}