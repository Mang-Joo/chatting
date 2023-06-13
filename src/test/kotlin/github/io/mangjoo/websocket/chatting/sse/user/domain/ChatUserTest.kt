package github.io.mangjoo.websocket.chatting.sse.user.domain

import github.io.mangjoo.websocket.chatting.sse.chat.application.ChatUser
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@DisplayName("ChatUser Domain Test")
class ChatUserTest {

    @Test
    fun `ChatUser Constructor Test`() {

        // Given
        val name = "mangjoo"

        // When
        val chatUser = ChatUser(name = name)

        // Then
        assertEquals(name, chatUser.name)
    }

    @Test
    fun `ChatUser Constructor Test with blank name`() {

        // Given
        val name = ""

        // When / Then
        assertThatThrownBy { ChatUser(name = name) }
            .hasMessage("name must not be blank")
    }

    @Test
    fun `ChatUser Join Test`() {

        // Given
        val name = "mangjoo"
        val sseEmitter = SseEmitter()

        // When
        val chatUser = ChatUser(name = name).join(sseEmitter)

        // Then
        assertEquals(name, chatUser.name)
        assertEquals(sseEmitter, chatUser.sseEmitter)
    }
}