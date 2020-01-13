package com.jinyue.provider;

import com.jinyue.common.api.IHelloWorld;

public class HelloWorldImpl implements IHelloWorld {
    public String sayHelloWorld(String name, String content) {
        return name + " say:" + content;
    }
}
