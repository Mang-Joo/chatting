package github.io.mangjoo.websocket.chatting.sse.user.api.response

import github.io.mangjoo.websocket.chatting.sse.user.domain.User
import java.util.*

data class CreateUserResponse(
    val id: UUID,
    val name: String
) {
    companion object {
        fun of(user: User) = CreateUserResponse(user.id, user.name)
    }
}