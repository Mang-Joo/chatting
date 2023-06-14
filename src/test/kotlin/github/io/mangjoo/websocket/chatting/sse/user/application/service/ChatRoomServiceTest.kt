package github.io.mangjoo.websocket.chatting.sse.user.application.service

import github.io.mangjoo.websocket.chatting.sse.chat.domain.room.ChatRoom
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*


class ChatRoomServiceTest {

    @Test
    fun `join chat room`() {
        val chatRoom = ChatRoom(roomName = "test")
        val userId = UUID.randomUUID()

        val addedUserRoom = chatRoom.add(userId)

        assertThat(addedUserRoom.users).contains(userId)
    }

}