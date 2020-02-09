package com.jinyue.spring.event.mockspringevent.listener;

import com.jinyue.spring.event.mockspringevent.event.AbstractContextEvent;

public interface ContextListener<T extends AbstractContextEvent> extends EventListener {
    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(T event);
}
