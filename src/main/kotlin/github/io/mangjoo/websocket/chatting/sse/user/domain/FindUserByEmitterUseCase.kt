package github.io.mangjoo.websocket.chatting.sse.user.domain

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

interface FindUserByEmitterUseCase {
    fun find(emitter: SseEmitter): ChatUser?
}