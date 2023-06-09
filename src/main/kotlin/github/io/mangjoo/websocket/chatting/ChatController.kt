package github.io.mangjoo.websocket.chatting

import github.io.mangjoo.websocket.chatting.domain.Chat
import github.io.mangjoo.websocket.chatting.domain.MessageType.*
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController {

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chat: Chat) = chat

    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    fun join(@Payload chat: Chat, simpMessageHeaderAccessor: SimpMessageHeaderAccessor): Chat = simpMessageHeaderAccessor
        .sessionAttributes?.put("username", chat.sender)
        .let { chat }
        .takeIf { it.type == JOIN } ?: throw IllegalArgumentException("Join message type is not JOIN")
}