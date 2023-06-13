package github.io.mangjoo.websocket.chatting.sse.chat.domain.room

import java.util.UUID

interface FindChatRoomUseCase {
    fun find(chatId: UUID): ChatRoom
}