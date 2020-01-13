package com.jinyue.consumer;

import com.jinyue.common.api.IHelloWorld;
import com.jinyue.consumer.proxy.RpcProxyFactory;

/**
 * z这个是consumer客户端测试类
 */
public class ConsumerTest {
    public static void main(String[] args) {
        IHelloWorld helloWorld = (IHelloWorld)new RpcProxyFactory(IHelloWorld.class).getProxyInstance();
        System.out.println(helloWorld.sayHelloWorld("jinyue", "hello world!"));

    }
}
