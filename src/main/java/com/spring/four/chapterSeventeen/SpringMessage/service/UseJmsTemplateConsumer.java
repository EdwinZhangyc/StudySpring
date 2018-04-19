package com.spring.four.chapterSeventeen.SpringMessage.service;

import com.spring.four.chapterSeventeen.SpringMessage.domain.Spittle;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.support.JmsUtils;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * 程序清单17.4 使用JmsTemplate接收消息
 */
public class UseJmsTemplateConsumer {

    private JmsOperations jmsOperations;

    public UseJmsTemplateConsumer(JmsOperations jmsOperations){
        this.jmsOperations = jmsOperations;
    }

    public Spittle receiveSpittleAlert () {

        //2、与发送端一致，使用receiveAndConvert来简化下述代码
        Spittle spittle1 = (Spittle)jmsOperations.receiveAndConvert();

        //1、使用receive（）接收消息
        ObjectMessage receivedMessage = (ObjectMessage)jmsOperations.receive();
        //获得对象
        try {
            return (Spittle)receivedMessage.getObject();
        } catch (JMSException e) {
            //抛出转换后的异常
            throw JmsUtils.convertJmsAccessException(e);
        }


    }
}