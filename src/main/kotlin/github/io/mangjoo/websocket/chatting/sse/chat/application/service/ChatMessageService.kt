package github.io.mangjoo.websocket.chatting.sse.chat.application.service

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.SendMessageResponse
import github.io.mangjoo.websocket.chatting.sse.chat.application.CacheChat
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessageRepository
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.SendMessageUseCase
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import github.io.mangjoo.websocket.chatting.sse.user.application.UserService
import org.springframework.stereotype.Service

@Service
class ChatMessageService(
    private val chatMessageRepository: ChatMessageRepository,
    private val chatRoomService: ChatRoomService,
    private val userService: UserService,
    private val cacheChat: CacheChat
) : SendMessageUseCase {

    override fun sendMessage(chatRoomId: java.util.UUID, userId: java.util.UUID, message: String) = with(ChatMessage(chatRoomId, userId, message)) {
        cacheChat.sendMessage(chatRoomId, this)
            .let {
                chatMessageRepository.save(this)
                val chatRoom: ChatRoom = chatRoomService.find(chatRoomId)
                val user = userService.find(userId)
                SendMessageResponse(chatRoom.id, chatRoom.roomName, user.name, message)
            }
    }


}