package github.io.mangjoo.websocket.chatting.sse.user.domain

interface CreateChatUserUseCase {
    fun create(chatUser: ChatUser): ChatUser
}