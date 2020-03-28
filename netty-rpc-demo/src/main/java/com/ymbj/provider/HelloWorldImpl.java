package com.ymbj.provider;

import com.ymbj.common.api.IHelloWorld;

/**
 * 服务提供者
 */
public class HelloWorldImpl implements IHelloWorld {
    public String sayHelloWorld(String name, String content) {
        return name + " say:" + content;
    }
}
