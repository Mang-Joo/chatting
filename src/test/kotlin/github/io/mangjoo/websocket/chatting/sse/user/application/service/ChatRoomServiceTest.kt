package github.io.mangjoo.websocket.chatting.sse.user.application.service

import org.junit.jupiter.api.Test
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter


class ChatRoomServiceTest {

    private val list: MutableList<SseEmitter> = mutableListOf()
    @Test
    fun `join chat room`() {
        val sseEmitter = SseEmitter(60000L)
        val sseEmitter2 = SseEmitter(6000L)

        list.add(sseEmitter)
        list.add(sseEmitter2)
        val let = sseEmitter.let { list.indexOf(sseEmitter) }

        println(list.size)
        println("let = ${let}")

    }

}