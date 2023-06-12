package github.io.mangjoo.websocket.chatting.sse.user.api.request

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser

data class CreateUserRequest(
    val name: String,
) {
    fun toDomain() = ChatUser(
        name = name
    )
}
