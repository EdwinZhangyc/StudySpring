package com.spring.four.chapterEighteen.WebSocketAndSTOMP.service.Impl;

import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.Notification;
import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.Spittle;
import com.spring.four.chapterEighteen.WebSocketAndSTOMP.service.SpittleFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 程序清单18.9 convertAndSendToUser()能够发送消息给特定用户
 */
@Service
public class SpittleFeedServiceImpl implements SpittleFeedService {

    private SimpMessagingTemplate messagingTemplate;
    //实现用户提及功能的正则表达式
    private Pattern pattern = Pattern.compile("\\@(\\S+)");

    @Autowired
    public SpittleFeedServiceImpl(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }
    @Override
    public void broadcastSpittle(Spittle spittle) {

        messagingTemplate.convertAndSend("/topic/spittlefeed", spittle);
        Matcher matcher = pattern.matcher(spittle.getMessage());
        if(matcher.find()){
            String username = matcher.group(1);
            messagingTemplate.convertAndSendToUser(
                    //发送提醒给用户
                    username, "/queue/notifications",
                    new Notification("You just got mentioned")
            );
        }

    }
}