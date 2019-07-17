package com.fx.study.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendSimpleMail() {
        //1.构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //2.设置邮件主题
        message.setSubject("这是一封测试邮件006");
        //3.设置邮件发送者
        message.setFrom("2764416290@qq.com");
        //4. 设置邮件接收者，可以有多个接收者
        message.setTo("mabaofeng530@126.com");
        //5.设置邮件抄送人，可以有多个抄送人
       /* message.setCc("371820637@qq.com");
        //6.设置隐秘抄送人，可以有多个
        message.setBcc("1406134098@qq.com");*/
        //7.设置邮件发送日期
        message.setSentDate(new Date());
        //8. 设置邮件的正文
        message.setText("这是测试邮件的正文");
        //9. 发送邮件
        javaMailSender.send(message);
    }
}


   /* @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("2764416290@qq.com");
        message.setTo("mabaofeng530@126.com");
        message.setCc("1971856055@qq.com");
        message.setBcc("1971856055@qq.com");
        message.setSentDate(new Date());
        message.setText("这是测试邮件的正文");
        context.getBean(JavaMailSender.class).send(message);
    }*/

