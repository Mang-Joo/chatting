package github.io.mangjoo.websocket.chatting.sse.user.domain

import java.util.*

interface FindUserByIdUseCase {
    fun find(id: UUID): ChatUser
}
