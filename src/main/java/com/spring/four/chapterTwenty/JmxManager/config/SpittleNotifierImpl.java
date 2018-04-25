package com.spring.four.chapterTwenty.JmxManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

import javax.management.Notification;

/**
 * 程序清单20.2 使用NotificationPublisher来发送JMX通知
 */
@Component
@ManagedResource("spitter:name=SpitterNotifier")
@ManagedNotification(notificationTypes = "SpitterNotifier.OneMillionSpittles", name = "TODO")
//实现NotificationPublisherAware接口
public class SpittleNotifierImpl implements NotificationPublisherAware {

    private NotificationPublisher notificationPublisher;

    //Annotation notificationPublisher
    @Autowired
    public SpittleNotifierImpl(NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    //发送通知
    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {

        new Notification("SpitterNotifier.OneMillionSpittles", this, 0);
    }
}