package com.abc.dynamicproxy.withoutimpl;

public class Test {
    @org.junit.Test
    public void testJdkDynamicProxyWithoutImpl() {
        IHello helloProxy = (IHello) new ProxyFactory(IHello.class).getProxyInstance();
        helloProxy.sayHello();
    }
}
