package com.jinyue.spring.event.mockspringevent;

import com.jinyue.spring.event.mockspringevent.event.AbstractContextEvent;
import com.jinyue.spring.event.mockspringevent.listener.ContextListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimpleApplicationEventMulticaster implements ApplicationEventMulticaster {

    private boolean async = false;


    private Executor taskExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    private List<ContextListener<?>> contextListeners = new ArrayList<ContextListener<?>>();

    
    public void addContextListener(ContextListener<?> listener) {
        contextListeners.add(listener);
    }

    public void removeContextListener(ContextListener<?> listener) {
        contextListeners.remove(listener);
    }

    public void removeAllListeners() {
        contextListeners.clear();
    }

    public void multicastEvent(AbstractContextEvent event) {
        doMulticastEvent(contextListeners, event);
    }

    private void doMulticastEvent(List<ContextListener<?>> contextListeners, AbstractContextEvent event) {
        for (ContextListener contextListener : contextListeners) {
            if (async) {
                // taskExecutor.execute(() -> invokeListener(contextListener, event));
                new Thread(() -> invokeListener(contextListener, event)).start();
            } else {
                invokeListener(contextListener, event);
            }
        }
    }

    private void invokeListener(ContextListener contextListener, AbstractContextEvent event) {
        contextListener.onApplicationEvent(event);
    }

    public void setAsync(boolean async) {
        this.async = async;
    }
}
