package github.io.mangjoo.websocket.chatting.sse.user.domain

import java.util.*

data class User(
    val id: UUID = UUID.randomUUID(),
    val name: String,
) {
    init {
        require(name.isNotBlank()) { "name must not be blank" }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        return name == other.name
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }


}
