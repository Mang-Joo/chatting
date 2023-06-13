package github.io.mangjoo.websocket.chatting.sse.chat.domain

import github.io.mangjoo.websocket.chatting.sse.chat.domain.message.ChatMessage
import org.assertj.core.api.Assertions.*
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
        assertThatThrownBy { ChatMessage(chatRoomId, sender, message) }
            .doesNotThrowAnyException()
        assertThat(chatRoomId).isEqualTo(chatMessage.chatRoomId)
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

    @Test
    fun `autoId test`() {
        // given
        val id = 1L
        val chatRoomId = UUID.randomUUID()
        val sender = "test sender"
        val message = "test message"
        val chatMessage = ChatMessage(chatRoomId, sender, message)

        // when
        val autoIdChatMessage = chatMessage.autoId(id)

        // then
        assertThat(id).isEqualTo(autoIdChatMessage.id)
    }
}