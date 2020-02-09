package com.jinyue.dynamicproxy.withoutimpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 注意这里是接口，传入的不是具体实现类而是接口，故用Class
    private Class target;

    public ProxyFactory(Class target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("我代理了一个没有具体类的接口");
                        return null;
                    }
                });
    }
}
