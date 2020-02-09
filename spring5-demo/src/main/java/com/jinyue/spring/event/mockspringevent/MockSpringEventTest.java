package com.jinyue.spring.event.mockspringevent;

import com.jinyue.spring.event.mockspringevent.event.ContextDestroyEvent;
import com.jinyue.spring.event.mockspringevent.event.ContextRunningEvent;
import com.jinyue.spring.event.mockspringevent.event.ContextStartEvent;
import com.jinyue.spring.event.mockspringevent.listener.ContextDestroyEventListener;
import com.jinyue.spring.event.mockspringevent.listener.ContextRunningEventListener;
import com.jinyue.spring.event.mockspringevent.listener.ContextStartEventListener;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class MockSpringEventTest {

    @Test
    public void testContextLifecycleEventInSync() {
        // 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addContextListener(new ContextStartEventListener());
        eventMulticaster.addContextListener(new ContextRunningEventListener());
        eventMulticaster.addContextListener(new ContextDestroyEventListener());
        // 发射容器启动事件ContextStartEvent
        eventMulticaster.multicastEvent(new ContextStartEvent());
        // 发射容器正在运行事件ContextRunningEvent
        eventMulticaster.multicastEvent(new ContextRunningEvent());
        // 发射容器正在运行事件ContextDestroyEvent
        eventMulticaster.multicastEvent(new ContextDestroyEvent());
    }

    @Test
    public void testContextLifecycleEventInAsync() throws InterruptedException {
        // 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addContextListener(new ContextStartEventListener());
        eventMulticaster.addContextListener(new ContextRunningEventListener());
        eventMulticaster.addContextListener(new ContextDestroyEventListener());

        ((SimpleApplicationEventMulticaster) eventMulticaster).setAsync(true);

        // 发射容器启动事件ContextStartEvent
        eventMulticaster.multicastEvent(new ContextStartEvent());
        // 发射容器正在运行事件ContextRunningEvent
        eventMulticaster.multicastEvent(new ContextRunningEvent());
        // 发射容器正在运行事件ContextDestroyEvent
        eventMulticaster.multicastEvent(new ContextDestroyEvent());
        // TODO 这里没明白为何主线程退出，非后台线程的子线程也会退出？？？为了测试，所有先用CountDownLatch锁住main线程先
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();

    }
}
