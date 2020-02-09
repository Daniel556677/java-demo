package com.jinyue.spring.event.mockspringevent;

import com.jinyue.spring.event.mockspringevent.event.AbstractContextEvent;
import com.jinyue.spring.event.mockspringevent.listener.ContextListener;

public interface ApplicationEventMulticaster {
    void addContextListener(ContextListener<?> listener);

    void removeContextListener(ContextListener<?> listener);

    void removeAllListeners();

    void multicastEvent(AbstractContextEvent event);

}
