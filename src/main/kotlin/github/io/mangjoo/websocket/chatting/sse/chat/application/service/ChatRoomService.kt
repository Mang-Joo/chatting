package github.io.mangjoo.websocket.chatting.sse.chat.application.service

import github.io.mangjoo.websocket.chatting.sse.chat.api.TIME_OUT_SECOND
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.SendMessageUseCase
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoomRepository
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.JoinChatRoomUseCase
import github.io.mangjoo.websocket.chatting.sse.user.application.ChatUserUseCaseService
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatUserService: ChatUserUseCaseService,
) : JoinChatRoomUseCase, SendMessageUseCase {
    private val logger = KotlinLogging.logger { }
    override fun join(chatId: UUID, userId: UUID) = SseEmitter(TIME_OUT_SECOND)
        .also { sseEmitter ->
            sseEmitter.onCompletion { outChatRoom(chatId, userId).also { logger.info { "Completion sse" } } }
            sseEmitter.onTimeout { outChatRoom(chatId, userId).also { logger.error { "Sse connection time out!" } } }
            sseEmitter.onError {
                logger.error { it.message }
                outChatRoom(chatId, userId)
            }
        }
        .let {
            val chatUser = chatUserService.find(userId)
            val chatRoom = chatRoomRepository.addChatUser(chatId, userId)
            JoinRoomResponse.of(chatRoom, chatUser.name)
        }

    private fun outChatRoom(chatId: UUID, userId: UUID) = chatRoomRepository
        .remove(chatId, userId)
        .also { logger.info { "out chat room: ${it.roomName}" } }

    override fun sendMessage(chatId: UUID, userId: UUID, message: String) = with(chatUserService.find(userId)) {
        val chatRoom = chatRoomRepository.findByChatId(chatId)
        val chatMessage = ChatMessage(chatRoomId = chatRoom.id, sender = name, message = message)
        val sendMessage = chatRoom.sendMessage(chatMessage.id)
//        val saveMessage = chatRepository.save(sendMessage)
//        SendMessageResponse.of(saveMessage, name, message)
        TODO()
    }

}