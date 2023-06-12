package github.io.mangjoo.websocket.chatting.sse.user.application

import github.io.mangjoo.websocket.chatting.sse.user.domain.*
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Service
class ChatUserService(
    private val chatUserRepository: ChatUserRepository,
) : SaveChatUserUseCase, FindUserByEmitterUseCase, FindUserByIdUseCase {
    override fun find(emitter: SseEmitter): ChatUser = chatUserRepository
        .findByEmitter(emitter)


    override fun save(chatUser: ChatUser): ChatUser = chatUserRepository
        .save(chatUser)

    override fun find(id: UUID): ChatUser = chatUserRepository
        .findById(id)

}