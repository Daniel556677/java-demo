package com.jinyue.consumer.proxy;

import com.jinyue.consumer.request.ConsumerNettyRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类，生成调用目标接口的代理类，这个代理类实质就是在InvocationHandler的invoke方法里面调用
 * netty的发送信息给服务端的相关请求方法而已，把调用目标接口类的相关信息（比如目标接口名，被调用的目标方法，
 * 被调用目标方法的参数类型，参数值）发送给netty服务端，netty服务端接收到请求的这些信息后，然后再从缓存map
 * （模拟注册中心）拿到provider的实现类，然后再利用反射进行目标方法的调用。
 */
public class RpcProxyFactory {
    private Class<?> target;

    public RpcProxyFactory(Class<?> target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return new ConsumerNettyRequest().sendRequest(target.getName(), method.getName(),
                                method.getParameterTypes(), args);
                    }
                });
    }
}
