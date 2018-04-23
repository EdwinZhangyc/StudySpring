package com.spring.four.chapterEighteen.WebSocketAndSTOMP.controller;

import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.Notification;
import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.SpittleForm;
import com.spring.four.chapterSeventeen.SpringMessage.domain.Spittle;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

@Controller
public class HandlerUser {

    @MessageMapping("/spittle")
    @SendToUser("/queue/notifications")
    public Notification handleSpittle(Principal principal, SpittleForm form){
        Spittle spittle = new Spittle(principal.getName(), form.getText(), new Date());
        spittleRepo.save(spittle);
        return new Notification("save spittle");
    }
}