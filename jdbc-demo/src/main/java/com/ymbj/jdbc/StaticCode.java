package com.ymbj.jdbc;

public class StaticCode {
    static {
        System.out.println("我是静态代码块，在Class.forName('StaticCode')加载我时，我这个静态方法会被触发调用");
    }
}
