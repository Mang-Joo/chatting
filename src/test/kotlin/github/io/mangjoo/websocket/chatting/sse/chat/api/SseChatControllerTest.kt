package github.io.mangjoo.websocket.chatting.sse.chat.api

import github.io.mangjoo.websocket.chatting.sse.user.fixture.signUpUser
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class SseChatControllerTest(
    @Autowired private val mockMvc: MockMvc
) {

    @Test
    fun `chat room save api Test`() {

        val name = "mangjoo"
        val uuid = UUID.randomUUID()

        val signUpUser = mockMvc.signUpUser

        mockMvc.post("/chat/create-room") {
            contentType = APPLICATION_JSON
            content = """
                {
                    "userId": "${signUpUser.id}",
                    "roomName": "mangjoo"
                }
            """.trimIndent()
        }.andExpect {
            status { isOk() }
            jsonPath("$.roomId") { isNotEmpty() }
            jsonPath("$.roomName") { value(name) }
        }

    }
}