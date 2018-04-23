package com.spring.four.chapterEighteen.WebSocketAndSTOMP.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 程序清单18.5 @EnableWebSocketMessageBroker注解能够在WebSocket之上启动STOMP
 */

@Configuration
//启动STOMP消息
@EnableWebSocketMessageBroker
public class WebSocketMessageBroker extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //为"/marcopolo"路径启动SockJS功能
        registry.addEndpoint("/marcopolo").withSockJS();
    }

    //默认情况下STOMP代理中继会假设代理监听localhost:61613，用户名与密码均为guest
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //使用内存代理的方式进行配置（开发环境使用）
        registry.enableSimpleBroker("/queue", "/topic");
        //使用STOMP代理来替换内存代理
        registry.enableStompBrokerRelay("/queue", "/topic")
                .setRelayHost("rabbit.someotherserver")
                .setRelayPort(62613)
                .setClientLogin("marcopolo")
                .setClientPasscode("letmein01");
        registry.setApplicationDestinationPrefixes("/app","foo");
    }
}