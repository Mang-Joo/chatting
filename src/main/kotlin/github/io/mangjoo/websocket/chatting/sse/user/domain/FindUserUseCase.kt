package github.io.mangjoo.websocket.chatting.sse.user.domain

import java.util.*

interface FindUserUseCase {
    fun find(id: UUID): User
}
