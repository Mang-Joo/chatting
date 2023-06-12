package github.io.mangjoo.websocket.chatting.polling

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.request


@SpringBootTest
@AutoConfigureMockMvc
class PollingControllerTest(
    @Autowired val mockMvc: MockMvc,
) {

    @Test
    fun helloTest() {

        val asyncListener = mockMvc
            .perform(MockMvcRequestBuilders.get("/polling/hello"))
            .andExpect(request().asyncStarted())
            .andReturn()

        asyncListener.asyncResult
            .also { println("it.toString() = $it") }

    }
}