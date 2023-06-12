package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.user.domain.ChatUser
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
}