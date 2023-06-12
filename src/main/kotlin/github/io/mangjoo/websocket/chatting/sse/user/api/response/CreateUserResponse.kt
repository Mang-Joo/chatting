package github.io.mangjoo.websocket.chatting.sse.user.api.response

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
import java.util.*

data class CreateUserResponse(
    val id: UUID,
    val name: String
) {
    companion object {
        fun of(chatUser: ChatUser) = CreateUserResponse(chatUser.id, chatUser.name)
    }
}