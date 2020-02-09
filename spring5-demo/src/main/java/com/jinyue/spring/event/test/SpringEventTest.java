package com.jinyue.spring.event.test;

import com.jinyue.spring.event.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 参考：https://www.cnblogs.com/xinde123/p/8918714.html
 */
public class SpringEventTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        MailSender sender  = (MailSender)annotationConfigApplicationContext.getBean("mailSender");
        sender.sendMail("北京");
    }
}