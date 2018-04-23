package com.spring.four.chapterEighteen.WebSocketAndSTOMP.controller;

import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.Shout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * 程序清单18.6  借助@MessageMapping注解能够在控制器中处理STOMP消息
 */
@Controller
public class MarcoController {

    private static final Logger logger = LoggerFactory.getLogger(MarcoController.class);

    //处理发自"/app/marco"目的地的消息
    @MessageMapping("marco")
    public void handleShout(Shout incoming) {
        logger.info("Received message: " + incoming.getMessage());
    }

    //在处理消息之后，发送消息
    @MessageMapping("marcoReturn")
    @SendTo("/topic/shout")//添加@SendTo注解，重载目的地
    public Shout handleShoutreturn(Shout incoming) {
        logger.info("Received message: " + incoming.getMessage());
        Shout outGoing = new Shout();
        outGoing.setMessage("Polo!");
        return outGoing;
    }

    @SubscribeMapping({"/marco"})//@SubScribeMapping所返回的Shout对象会直接返回到客户端中
    public Shout handleSubscription(){
        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }

    //处理异常
    @MessageExceptionHandler
    public void handlerExceptions(Throwable t){
        logger.error("Error handling message: " + t.getMessage());
    }
}