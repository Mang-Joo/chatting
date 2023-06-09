package github.io.mangjoo.websocket.chatting.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {

    /**
     * WebSocket 연결을 위한 EndPoint
     */
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/websocket")
            .setAllowedOrigins("*")
            .withSockJS()
    }

    /**
     * 메세지를 주고받을 엔드포인트 Prefix 설정
     * setApplicationDestinationPrefixes: client -> server Endpoint Prefix
     * enableSimpleBroker: server -> client(subscribe) Endpoint Prefix
     */
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.apply {
            setApplicationDestinationPrefixes("/app")
            enableSimpleBroker("/topic")
        }
    }
}