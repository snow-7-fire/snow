package com.zy.snow.study.spring.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description: com.zy.snow.study.spring.mail
 * @author: Snow
 * @Date: 2020/5/26
 */
@Component
@Slf4j
public class MailClient {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 发送邮件
     *
     * @param recipient 收件人
     * @param subject   主题
     * @param content   内容
     */
    public void sendMail(String recipient, String subject, String content) {
        log.info("正在发送邮件 from:{}",sender);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(recipient);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);
        } catch (MessagingException e) {
            log.error("邮箱系统错误:{}",e.getMessage(),e);
        }
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
        log.info("邮件已发送 To:{}",recipient);
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
}
