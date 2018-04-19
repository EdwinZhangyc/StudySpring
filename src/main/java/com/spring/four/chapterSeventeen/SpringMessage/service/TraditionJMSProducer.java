package com.spring.four.chapterSeventeen.SpringMessage.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * 程序订单17.1 使用传统的JMS（不使用Spring）发送消息
 */
public class TraditionJMSProducer {

    public void traditionJMSProducer () {

        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;

        try {
            //创建连接
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("spitter.queue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();

            message.setText("Hello world");
            //发送消息
            producer.send(message);
        } catch(JMSException e){
            e.printStackTrace();
        } finally {
            try {
                if(session != null) session.close();
                if(conn != null) conn.close();
            } catch(JMSException e){

            }
        }
    }


}