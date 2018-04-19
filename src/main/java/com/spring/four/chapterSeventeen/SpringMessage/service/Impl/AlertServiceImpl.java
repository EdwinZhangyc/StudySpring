package com.spring.four.chapterSeventeen.SpringMessage.service.Impl;

import com.spring.four.chapterSeventeen.SpringMessage.domain.Spittle;
import com.spring.four.chapterSeventeen.SpringMessage.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 程序清单17.3 使用JmsTemplate发送一个Spittle
 */
public class AlertServiceImpl implements AlertService {

    private JmsOperations jmsOperations;

    //注入JmsTemplate
    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations){
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendSpittlerAlert(Spittle spittle) {

        //发送消息
        jmsOperations.send(
                //指定目的地，可以在定义jms模版时进行默认指定，在Spring配置文件中进行默认指定
                "spittle.alert.queue",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(spittle);//创建消息
                    }
                });

        //使用message convert为我们创建消息,可以将以上代码缩减为1行，同时在配置文件中指定了默认目的地
        jmsOperations.convertAndSend(spittle);
    }
}