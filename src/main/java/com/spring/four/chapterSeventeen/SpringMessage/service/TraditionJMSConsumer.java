package com.spring.four.chapterSeventeen.SpringMessage.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * 程序清单17.2 使用传统的JMS（不使用Spring）接收消息
 */
public class TraditionJMSConsumer {

    public void traditionJMSConsumer () {

        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;

        try {

            conn = cf.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("spitter.queue");
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage)message;
            System.out.println("GOT A MESSAGE: " + textMessage.getText());
            conn.start();
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