package github.io.mangjoo.websocket.chatting.sse.user.fixture

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import github.io.mangjoo.websocket.chatting.sse.user.api.response.CreateUserResponse
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

class Fixture {

}

val MockMvc.signUpUser: CreateUserResponse
    get() = post("/api/v1/users") {
        contentType = MediaType.APPLICATION_JSON
        content = """
                {
                    "name": "mangjoo"
                }
            """.trimIndent()
    }.andReturn()
        .response
        .contentAsString
        .let { jacksonObjectMapper().readValue(it, CreateUserResponse::class.java) }