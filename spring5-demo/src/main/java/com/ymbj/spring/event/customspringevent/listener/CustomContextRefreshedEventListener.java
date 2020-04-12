package com.ymbj.spring.event.customspringevent.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 自定义一个事件监听器监听ContextRefreshedEvent
 */
@Component
public class CustomContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("=======I am a cuctom ContextRefreshedEvent listener,I am listening ContextRefreshedEvent=====");
    }
}
