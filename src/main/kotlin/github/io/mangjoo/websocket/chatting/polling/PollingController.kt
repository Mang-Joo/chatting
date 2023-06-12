package github.io.mangjoo.websocket.chatting.polling

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult
import java.util.concurrent.Executors

@RestController
@RequestMapping("/polling")
class PollingController {


    private val executorService = Executors.newFixedThreadPool(5)

    @GetMapping("/hello")
    fun hello(): DeferredResult<Response> {
        val deferredResult = DeferredResult<Response>(3000, Response("Timeout"))

        executorService.execute {
            Thread.sleep(1000)
            println("hello!!!")
            deferredResult.setResult(Response("Hello"))
        }


        deferredResult.onCompletion {
            println("onCompletion")
        }

        return deferredResult
    }

    class Response(
        private val message: String,
    ) {
        override fun toString(): String {
            return "Response(message='$message')"
        }
    }
}
