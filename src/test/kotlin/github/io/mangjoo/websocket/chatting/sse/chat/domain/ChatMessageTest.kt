package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.UUID

@DisplayName("ChatMessage Domain Test")
class ChatMessageTest {

    @Test
    fun `constructor test`() {
        // given
        val chatRoomId = UUID.randomUUID()
        val sender = UUID.randomUUID()
        val message = "test message"

        // when
        val chatMessage = ChatMessage(chatRoomId, sender, message)

        // then
        assertThatCode { ChatMessage(chatRoomId, sender, message) }
            .doesNotThrowAnyException()
        assertThat(chatRoomId).isEqualTo(chatMessage.chatRoomId)
    }

    @Test
    fun `constructor throw test`() {
        // given
        val chatRoomId = UUID.randomUUID()
        val sender = UUID.randomUUID()
        val message = ""

        // when / then
        assertThatThrownBy { ChatMessage(chatRoomId, sender, message) }
    }
}