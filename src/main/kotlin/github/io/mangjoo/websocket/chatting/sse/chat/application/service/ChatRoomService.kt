package github.io.mangjoo.websocket.chatting.sse.chat.application.service

import github.io.mangjoo.websocket.chatting.sse.chat.api.TIME_OUT_SECOND
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.domain.ChatRepository
import github.io.mangjoo.websocket.chatting.sse.chat.domain.JoinChatRoomUseCase
import github.io.mangjoo.websocket.chatting.sse.user.application.ChatUserService
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Service
class ChatRoomService(
    private val chatRepository: ChatRepository,
    private val chatUserService: ChatUserService,
) : JoinChatRoomUseCase {
    override fun join(chatId: UUID, userId: UUID) = SseEmitter(TIME_OUT_SECOND)
        .also { sseEmitter ->
            sseEmitter.onCompletion { outChatRoom(chatId, sseEmitter) }
            sseEmitter.onTimeout { outChatRoom(chatId, sseEmitter) }
            sseEmitter.onError { outChatRoom(chatId, sseEmitter) }
        }
        .let {
            val chatUser = chatUserService.find(userId)
            val chatRoom = chatRepository.addChatUser(chatId, chatUser.join(it))
            JoinRoomResponse.of(chatRoom, chatUser.name)
        }

    private fun outChatRoom(chatId: UUID, sseEmitter: SseEmitter) = chatRepository
        .remove(chatId, chatUserService.find(sseEmitter))


}