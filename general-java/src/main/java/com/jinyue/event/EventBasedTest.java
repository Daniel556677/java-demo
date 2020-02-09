package com.jinyue.event;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * 参考：http://www.iocoder.cn/Spring/ApplicationContextEvent/?vip
 *
 * 鼠标点击的话，会触发相关鼠标点击监听方法onClick
 */
public class EventBasedTest {

    @Test
    public void test() {
        Mouse mouse = new Mouse();
        mouse.addListener(new MouseListener() {
            public void onClick(Mouse mouse) {
                System.out.println("Listener#1 called");
                mouse.addListenerCallback();
            }
        });
        mouse.addListener(new MouseListener() {
            public void onClick(Mouse mouse) {
                System.out.println("Listener#2 called");
                mouse.addListenerCallback();
            }
        });
        mouse.click();
        assertTrue("2 listeners should be invoked but only "+mouse.getListenerCallbacks()+" were", mouse.getListenerCallbacks() == 2);
    }
}


class Mouse {
    private List<MouseListener> listeners = new ArrayList<MouseListener>();
    private int listenerCallbacks = 0;

    public void addListenerCallback() {
        listenerCallbacks++;
    }

    public int getListenerCallbacks() {
        return listenerCallbacks;
    }

    public void addListener(MouseListener listener) {
        listeners.add(listener);
    }

    public void click() {
        System.out.println("Clicked !");
        for (MouseListener listener : listeners) {
            listener.onClick(this);
        }
    }
}

interface MouseListener {
    public void onClick(Mouse source);
}
