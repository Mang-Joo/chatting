package github.io.mangjoo.websocket.chatting.sse.chat.application

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage

data class ChatUsers(
    val chatUsers: List<ChatUser> = mutableListOf(),
) {

    fun add(chatUser: ChatUser) = ChatUsers(chatUsers.plusElement(chatUser))

    val size get() = chatUsers.size

    fun out(chatUser: ChatUser) = ChatUsers(chatUsers.minusElement(chatUser))
    fun sendChatUsers(message: ChatMessage) = chatUsers
        .map { it.sendChatUser(message) }
        .toList()
        .let { ChatUsers(it) }

}