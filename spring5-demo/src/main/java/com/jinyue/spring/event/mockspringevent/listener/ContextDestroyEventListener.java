package com.jinyue.spring.event.mockspringevent.listener;

import com.jinyue.spring.event.mockspringevent.event.AbstractContextEvent;
import com.jinyue.spring.event.mockspringevent.event.ContextDestroyEvent;

public class ContextDestroyEventListener implements ContextListener<AbstractContextEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextDestroyEvent) {
            System.out.println("容器销毁。。。，销毁时间为：" + event.getTimestamp());
        }
    }
}
