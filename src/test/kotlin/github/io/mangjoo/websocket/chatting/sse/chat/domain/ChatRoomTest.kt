package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.application.ChatUser
import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@DisplayName("ChatRoom Domain Test")
class ChatRoomTest {

    @Test
    fun `add user to chat room`() {
        // given
        val chatRoom = ChatRoom(roomName = "test room")
        val chatUser = ChatUser(name = "test user", sseEmitter = SseEmitter())

        // when
        val addUserChatRoom = chatRoom.add(chatUser)

        // then
        assertThat(1).isEqualTo(addUserChatRoom.numberOfPeople)
    }

    @Test
    fun `remove user to chat room`() {
        // given
        val chatRoom = ChatRoom(roomName = "test room")
        val chatUser = ChatUser(name = "test user", sseEmitter = SseEmitter())
        val addUserChatRoom = chatRoom.add(chatUser)

        // when
        val removeUserChatRoom = addUserChatRoom.outChatUser(chatUser)

        // then
        assertThat(0).isEqualTo(removeUserChatRoom.numberOfPeople)
    }

    @Test
    fun `send chat message test`() {
        // given
        val chatRoom = ChatRoom(roomName = "test room")
        val chatUser = ChatUser(name = "test user", sseEmitter = SseEmitter())
        val message = ChatMessage(chatRoomId = chatRoom.id, message = "test message", sender = chatUser.name)

        // when
        val sendMessageChatRoom = chatRoom.sendMessage(message)

        // then
        assertThat(1).isEqualTo(sendMessageChatRoom.messageCount)
    }
}