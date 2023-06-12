package github.io.mangjoo.websocket.chatting.sse.user.api

import github.io.mangjoo.websocket.chatting.sse.user.api.request.CreateUserRequest
import github.io.mangjoo.websocket.chatting.sse.user.api.response.CreateUserResponse
import github.io.mangjoo.websocket.chatting.sse.user.application.ChatUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val chatUserService: ChatUserService
) {

    @PostMapping
    fun create(
        @RequestBody createUserRequest: CreateUserRequest
    ) = chatUserService.create(createUserRequest.toDomain())
        .let { ResponseEntity.ok(CreateUserResponse.of(it)) }
}