package github.io.mangjoo.websocket.chatting.sse.user.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest(
    @Autowired private val mockMvc: MockMvc
) {

    @Test
    fun `user save api Test`() {

        val name = "mangjoo"

        mockMvc.post("/api/v1/users") {
            contentType = APPLICATION_JSON
            content = """
                {
                    "name": "mangjoo"
                }
            """.trimIndent()
        }.andExpect {
            status { isOk() }
            jsonPath("$.id") { isNotEmpty() }
            jsonPath("$.name") { value(name) }
        }

    }

}