package github.io.mangjoo.websocket.chatting.sse.chat.application

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class CacheChat(
    private val chatRoom: Map<UUID, ChatUsers> = mapOf()
) {
    fun createChatRoom(chatRoomId: UUID, chatUser: ChatUser) =
        CacheChat(chatRoom.plus(Pair(chatRoomId, ChatUsers(listOf(chatUser)))))
            .let { chatRoomId }

    fun sendMessage(chatRoomId: UUID, chatMessage: ChatMessage) =
        chatRoom[chatRoomId]
            ?.sendChatUsers(chatMessage)
            ?.let { chatRoomId } ?: throw IllegalArgumentException("채팅방이 존재하지 않습니다.")
}