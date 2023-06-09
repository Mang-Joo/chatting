package github.io.mangjoo.websocket.chatting.domain

class Chat(
    val type: MessageType,
    val content: String,
    val sender: String
) {
}