package github.io.mangjoo.websocket.chatting.sse.user.api.request

import github.io.mangjoo.websocket.chatting.sse.user.domain.User

data class CreateUserRequest(
    val name: String,
) {
    fun toDomain() = User(
        name = name
    )
}
