package github.io.mangjoo.websocket.chatting.sse.chat.application.service

import github.io.mangjoo.websocket.chatting.sse.chat.api.TIME_OUT_SECOND
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.CreateRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.application.CacheChat
import github.io.mangjoo.websocket.chatting.sse.chat.application.ChatUser
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.*
import github.io.mangjoo.websocket.chatting.sse.user.application.UserService
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.UUID

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatUserService: UserService,
    private val cacheChat: CacheChat
) : JoinChatRoomUseCase, FindChatRoomUseCase, CreateChatRoomUseCase {
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
            cacheChat.createChatRoom(chatId, ChatUser(chatUser.id, it))
            val chatRoom = chatRoomRepository.addChatUser(chatId, userId)
            JoinRoomResponse.of(chatRoom, chatUser.name)
        }

    private fun outChatRoom(chatId: UUID, userId: UUID) = chatRoomRepository
        .remove(chatId, userId)
        .also { logger.info { "out chat room: ${it.roomName}" } }

    override fun find(chatId: UUID): ChatRoom = chatRoomRepository.findByChatRoomId(chatId)

    override fun create(roomName: String, userId: UUID) = chatRoomRepository
        .save(ChatRoom.createRoom(roomName, userId))
        .also { logger.info { "create chat room: ${it.roomName}" } }
        .also { join(it.id, userId) }
        .let { CreateRoomResponse.of(it) }

}