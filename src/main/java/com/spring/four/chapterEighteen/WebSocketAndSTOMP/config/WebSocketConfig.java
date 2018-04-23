package com.spring.four.chapterEighteen.WebSocketAndSTOMP.config;

import com.spring.four.chapterEighteen.WebSocketAndSTOMP.service.MarcoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 程序清单18.2 在Java配置中，启动？WebSocket并映射消息处理器
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //将MarcoHandler映射到"/marco"
        registry.addHandler(marcoHandler(), "/marco");//当使用WebSocket时配置
        //如果WebSocket不可用时，使用fallback plan SockJS时配置
        registry.addHandler(marcoHandler(), "/marco").withSockJS();

    }

    @Bean
    public  WebSocketHandler marcoHandler() {

        //声明MarcoHandler bean
        return new MarcoHandler();
    }
}