package com.ymbj.consumer;

import com.ymbj.common.api.IHelloWorld;
import com.ymbj.consumer.proxy.RpcProxyFactory;

/**
 * z这个是consumer客户端测试类
 */
public class ConsumerTest {
    public static void main(String[] args) {
        IHelloWorld helloWorld = (IHelloWorld)new RpcProxyFactory(IHelloWorld.class).getProxyInstance();
        System.out.println(helloWorld.sayHelloWorld("jinyue", "hello world!"));

    }
}
