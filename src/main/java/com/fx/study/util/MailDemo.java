package com.fx.study.util;

import com.fx.study.StudyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @auther: mabaofeng
 * @date: 2019/7/17 15:21
 * @description:
 */

@Component
public class MailDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StudyApplication.class, args);
        JavaMailSender mailSender = context.getBean(JavaMailSender.class);

        //1.构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //2.设置邮件主题
        message.setSubject("这是一封测试邮件005001");
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
        mailSender.send(message);
        System.out.println("发送成功！");
    }
}
