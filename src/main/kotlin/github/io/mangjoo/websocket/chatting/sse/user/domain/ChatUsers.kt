package github.io.mangjoo.websocket.chatting.sse.user.domain

data class ChatUsers(
    val emitters: List<ChatUser> = mutableListOf(),
) {
    constructor(chatUser: ChatUser) : this(listOf(chatUser))

    fun add(chatUser: ChatUser) = emitters.plus(chatUser)
    fun remove(chatUser: ChatUser) = emitters.minus(chatUser)
}