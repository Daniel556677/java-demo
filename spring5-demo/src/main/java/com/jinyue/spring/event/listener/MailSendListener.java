package com.jinyue.spring.event.listener;

import com.jinyue.spring.event.customevent.MailSendEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 定义一个该事件的监听器MailSendListener
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        MailSendEvent event = mailSendEvent;
        System.out.println("MailSender向"+ event.getTo()+ "发送了邮件");
    }
}
