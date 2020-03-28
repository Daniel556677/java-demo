package com.ymbj.spring.event.mockspringevent.listener;

import com.ymbj.spring.event.mockspringevent.event.AbstractContextEvent;
import com.ymbj.spring.event.mockspringevent.event.ContextStartEvent;

public class ContextStartEventListener implements ContextListener<AbstractContextEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextStartEvent) {
            System.out.println("容器启动。。。，启动时间为：" + event.getTimestamp());
        }
    }
}
