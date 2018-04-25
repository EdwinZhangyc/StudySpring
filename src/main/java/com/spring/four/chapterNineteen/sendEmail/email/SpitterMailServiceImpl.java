package com.spring.four.chapterNineteen.sendEmail.email;

import com.spring.four.chapterNineteen.sendEmail.domain.Spittle;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * 程序清单19.1 使用Spring的MailSender发送Email
 */
@Component
public class SpitterMailServiceImpl implements SpitterMailService {

  private JavaMailSender mailSender;

  @Autowired
  public SpitterMailServiceImpl(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  /* (non-Javadoc)
   * @see spittr.email.SpitterMailService#sendSimpleSpittleEmail(java.lang.String, spittr.domain.SpittleControllerManagedOperations)
   */
  /**
   * 程序清单19.1 使用Spring的MailSender发送Email
   * 发送最简单的Email
   * @param to
   * @param spittle
   */
  @Override
  public void sendSimpleSpittleEmail(String to, Spittle spittle) {

    //构造消息
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    String spitterName = spittle.getSpitter().getFullName();
    //Email地址
    mailMessage.setFrom("zyc_wyzh@163.com");
    mailMessage.setTo(to);
    mailMessage.setSubject("New spittle from " + spitterName);
    //设置消息文本
    mailMessage.setText(spitterName + " say: " + spittle.getText());
    mailSender.send(mailMessage);
  }



  /* (non-Javadoc)
     * @see spittr.email.SpitterMailService#sendSpittleEmailWithAttachment(java.lang.String, spittr.domain.SpittleControllerManagedOperations)
     */

  /**
   * 程序清单19.2 使用MimeMessageHelper发送带有附件的Email
   * @param to
   * @param spittle
   * @throws MessagingException
   */
  @Override
  public void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    //这里布尔值为ture表明这个消息是multipart类型的，  构造消息helper
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    String spitterName = spittle.getSpitter().getFullName();
    //Email地址
    helper.setFrom("zyc_wyzh@163.com");
    helper.setTo(to);
    helper.setSubject("New spittle from " + spitterName);
    //设置消息文本
    helper.setText(spitterName + " say: " + spittle.getText());

    //设置添加附件
    //路径在resource下，fileSystemResource表示文件路径
    FileSystemResource fileSystemResource = new FileSystemResource("/config/chapterNineteen/coupon.jpg");
    helper.addAttachment("coupon.jpg", fileSystemResource);

    mailSender.send(message);
  }

  /**
   * 19.2.2 发送富文本内容的Email
   * @param to
   * @param spittle
   * @throws MessagingException
   */
  @Override
  public void sendRichSpittlerEmail(String to, Spittle spittle) throws MessagingException {
    String html = "<html>\n" +
            "    <body>\n" +
            "        <img src='cid:spittlrLogo'/>\n" +
            "        <h4>\n" +
            spittle.getSpitter().getFullName() + "\n" +
            "        say...</h4>\n" +
            "        <i>\n" +
            "            \n" +
            "        </i>\n" +
            "    </body>\n" +
            "</html>";
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    String spitterName = spittle.getSpitter().getFullName();
    helper.setFrom("zyc_wyzh@163.com");
    helper.setTo(to);
    helper.setSubject("New spittle from " + spitterName);
    //设置HTML消息文本
    helper.setText(html, true);

    //添加嵌入式图片，以上html的img标签中的引用，在类路径下进行查找
    ClassPathResource imagePath = new ClassPathResource("coupon.jpg");
    //添加内联图片
    helper.addInline("spittlrLogo", imagePath);

    mailSender.send(message);
  }


  /**
   * 19.3.1 使用Velocity构建Email
   */
  @Autowired
  private VelocityEngine velocityEngine;

  @Override
  public void sendVelocityEngine(String to, Spittle spittle) throws MessagingException {

    Map<String, Object> model = new HashMap<String, Object>();
    model.put("spitterName", spittle.getSpitter().getFullName());
    model.put("spittleText", spittle.getText());
    //参数说明1、Velocity引擎、模板名称在类的根路径下、模型map
    String emailText = VelocityEngineUtils.mergeTemplateIntoString(
            velocityEngine,
            "com.spring.four.chapterNineteen.sendEmail.email.emailTemplate.vm",
            model);

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    String spitterName = spittle.getSpitter().getFullName();
    helper.setFrom("zyc_wyzh@163.com");
    helper.setTo(to);
    helper.setSubject("New spittle from " + spitterName);
    //设置HTML消息文本
    helper.setText(emailText, true);
    //添加嵌入式图片，以上html的img标签中的引用，在类路径下进行查找
    ClassPathResource imagePath = new ClassPathResource("coupon.jpg");
    //添加内联图片
    helper.addInline("spittlrLogo", imagePath);
    mailSender.send(message);
  }

}
