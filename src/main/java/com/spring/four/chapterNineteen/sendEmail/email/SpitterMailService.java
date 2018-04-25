package com.spring.four.chapterNineteen.sendEmail.email;


import com.spring.four.chapterNineteen.sendEmail.domain.Spittle;

import javax.mail.MessagingException;

public interface SpitterMailService {

  public abstract void sendSimpleSpittleEmail(String to, Spittle spittle);

  public abstract void sendSpittleEmailWithAttachment(String to, Spittle spittle)
      throws MessagingException;

  public abstract void sendRichSpittlerEmail (String to, Spittle spittle)
      throws MessagingException;

  public abstract void sendVelocityEngine(String to, Spittle spittle)
    throws MessagingException;
}