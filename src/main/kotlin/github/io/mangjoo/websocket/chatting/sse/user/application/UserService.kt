package github.io.mangjoo.websocket.chatting.sse.user.application

import github.io.mangjoo.websocket.chatting.sse.user.domain.CreateChatUserUseCase
import github.io.mangjoo.websocket.chatting.sse.user.domain.FindUserUseCase
import github.io.mangjoo.websocket.chatting.sse.user.domain.User
import github.io.mangjoo.websocket.chatting.sse.user.domain.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
) : CreateChatUserUseCase, FindUserUseCase {


    override fun create(chatUser: User): User = userRepository.save(chatUser)

    override fun find(id: UUID): User = userRepository.findById(id)

}