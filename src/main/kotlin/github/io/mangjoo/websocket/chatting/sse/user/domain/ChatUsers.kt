package github.io.mangjoo.websocket.chatting.sse.user.domain

data class ChatUsers(
    val chatUsers: List<ChatUser> = mutableListOf(),
) {
    constructor(chatUser: ChatUser) : this(listOf(chatUser))

    fun add(chatUser: ChatUser) = ChatUsers(chatUsers.plusElement(chatUser))

    val size get() = chatUsers.size
}