package github.io.mangjoo.websocket.chatting.sse.chat.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

@DisplayName("ChatMessage Domain Test")
class ChatMessageTest {

    @Test
    fun `constructor test`() {
        // given
        val chatRoomId = UUID.randomUUID()
        val sender = "test sender"
        val message = "test message"

        // when
        val chatMessage = ChatMessage(chatRoomId, sender, message)

        // then
        assertDoesNotThrow { ChatMessage(chatRoomId, sender, message) }
        assertEquals(chatRoomId, chatMessage.chatRoomId)
        assertEquals(sender, chatMessage.sender.userName)
        assertEquals(message, chatMessage.message)
    }

    @Test
    fun `constructor throw test`() {
        // given
        val chatRoomId = UUID.randomUUID()
        val sender = "test sender"
        val message = ""

        // when / then
        assertThatThrownBy { ChatMessage(chatRoomId, sender, message) }
    }
}