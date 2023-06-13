package github.io.mangjoo.websocket.chatting.sse.chat.api

import github.io.mangjoo.websocket.chatting.sse.chat.api.request.CreateRoomRequest
import github.io.mangjoo.websocket.chatting.sse.chat.api.request.SendMessageRequest
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.CreateRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.JoinRoomResponse
import github.io.mangjoo.websocket.chatting.sse.chat.api.response.SendMessageResponse
import github.io.mangjoo.websocket.chatting.sse.chat.application.service.ChatMessageService
import github.io.mangjoo.websocket.chatting.sse.chat.application.service.ChatRoomService
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

const val TIME_OUT_SECOND = 6000L

@RestController
@RequestMapping("/sse")
class SseChatController(
    private val chatRoomService: ChatRoomService,
    private val chatMessageService: ChatMessageService
) {
    @GetMapping("/{chat-id}/{user-id}", produces = [TEXT_EVENT_STREAM_VALUE])
    fun connection(
        @PathVariable(value = "chat-id") chatId: UUID,
        @PathVariable(value = "user-id") userId: UUID,
    ): ResponseEntity<JoinRoomResponse> = chatRoomService
        .join(chatId, userId)
        .let { ResponseEntity.ok(it) }

    @PostMapping("/create-room")
    fun createRoom(
        @RequestBody createRoomRequest: CreateRoomRequest
    ): ResponseEntity<CreateRoomResponse> = chatRoomService
        .create(createRoomRequest.roomName, createRoomRequest.userIdToUUID)
        .let { ResponseEntity.ok(it) }

    @PostMapping("/send-message/{chat-id}/{user-id}")
    fun sendMessage(
        @PathVariable(value = "chat-id") chatId: UUID,
        @PathVariable(value = "user-id") userId: UUID,
        @RequestBody sendMessageRequest: SendMessageRequest,
    ): ResponseEntity<SendMessageResponse> = chatMessageService
        .sendMessage(chatId, userId, sendMessageRequest.message)
        .let { ResponseEntity.ok(it) }

}