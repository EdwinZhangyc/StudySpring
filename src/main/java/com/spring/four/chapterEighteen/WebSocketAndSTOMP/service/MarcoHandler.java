package com.spring.four.chapterEighteen.WebSocketAndSTOMP.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * 程序清单18.1 MarcoHandler处理通过WebSocket传送的文本消息
 * 需要扩展AbstractWebSocketHandler
 */
public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(MarcoHandler.class);

    //处理文本消息
    protected void handleTextMessgae(WebSocketSession session, TextMessage message) throws Exception{

        logger.info("Received message: " + message.getPayload());
        //模拟延时
        Thread.sleep(2000);
        //发送文本消息
        session.sendMessage(new TextMessage("Polo!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection establelished");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Connection closed. Status: " + status);
    }
}