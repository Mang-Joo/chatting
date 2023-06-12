package github.io.mangjoo.websocket.chatting.sse.chat.api

import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.application.service.ChatRoomService
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

const val TIME_OUT_SECOND = 6000L

@RestController
@RequestMapping("/sse")
class SseChatController(
    private val chatRoomService: ChatRoomService,
) {
    @GetMapping("/{chat-id}/{user-id}", produces = [TEXT_EVENT_STREAM_VALUE])
    fun connection(
        @PathVariable(value = "chat-id") chatId: UUID,
        @PathVariable(value = "user-id") userId: UUID
    ): ResponseEntity<JoinRoomResponse> = chatRoomService
        .join(chatId, userId)
        .let { ResponseEntity.ok(it) }
}