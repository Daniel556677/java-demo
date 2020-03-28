package com.ymbj.spring.event.mockspringevent.listener;

import com.ymbj.spring.event.mockspringevent.event.AbstractContextEvent;
import com.ymbj.spring.event.mockspringevent.event.ContextRunningEvent;

public class ContextRunningEventListener implements ContextListener<AbstractContextEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextRunningEvent) {
            System.out.println("容器开始运行。。。");
            try {
                Thread.sleep(3000);
                System.out.println("容器运行结束。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
