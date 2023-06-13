package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

@DisplayName("ChatRoom Domain Test")
class ChatRoomTest {

    @Test
    fun `add user to chat room`() {
        // given
        val chatRoom = ChatRoom(roomName = "test room")
        val userId = UUID.randomUUID()

        // when
        val addUserChatRoom = chatRoom.add(userId)

        // then
        assertThat(1).isEqualTo(addUserChatRoom.numberOfPeople)
    }

    @Test
    fun `remove user to chat room`() {
        // given
        val chatRoom = ChatRoom(roomName = "test room")
        val userId = UUID.randomUUID()
        val addUserChatRoom = chatRoom.add(userId)

        // when
        val removeUserChatRoom = addUserChatRoom.outChatUser(userId)

        // then
        assertThat(0).isEqualTo(removeUserChatRoom.numberOfPeople)
    }
}