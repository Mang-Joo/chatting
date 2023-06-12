package github.io.mangjoo.websocket.chatting.sse.user.domain

interface SaveChatUserUseCase {
    fun save(chatUser: ChatUser): ChatUser
}