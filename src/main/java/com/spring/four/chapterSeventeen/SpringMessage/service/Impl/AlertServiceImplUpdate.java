package com.spring.four.chapterSeventeen.SpringMessage.service.Impl;

import com.spring.four.chapterSeventeen.SpringMessage.domain.Spittle;
import com.spring.four.chapterSeventeen.SpringMessage.service.AlertService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("alertService")
public class AlertServiceImplUpdate implements AlertService {

    private JavaMailSender javaMailSender;
    private String alertEmailAddress;

    public AlertServiceImplUpdate(JavaMailSender javaMailSender, String alertEmailAddress) {
        this.javaMailSender = javaMailSender;
        this.alertEmailAddress = alertEmailAddress;
    }

    @Override
    public void sendSpittlerAlert(Spittle spittle) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String spitterName = spittle.getSpitter().getFullName();
        mailMessage.setFrom("zyc_@163.com");
        mailMessage.setTo(alertEmailAddress);
        mailMessage.setSubject("New spittle from " + spitterName);
        mailMessage.setText(spitterName + " says: " + spittle.getMessage());
        javaMailSender.send(mailMessage);

    }
}