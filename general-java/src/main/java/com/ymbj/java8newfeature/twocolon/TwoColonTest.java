package com.ymbj.java8newfeature.twocolon;

import org.junit.Test;

/**
 * 总结：我们可以把类Something中的方法static String startsWith(String s){...}、String endWith(String s){...}、
 * Something(String something){...}看作是接口IConvert的实现，因为它们都符合接口定义的那个“模版”，
 * 有传参类型F以及返回值类型T。比如构造方法Something(String something)，它传参为String类型，
 * 返回值类型为Something。注解@FunctionalInterface保证了接口有且仅有一个抽象方法，所以JDK能准确地匹配到相应方法。
 * ————————————————
 * 版权声明：本文为CSDN博主「kegaofei」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/kegaofei/article/details/80582356
 */
public class TwoColonTest {
    public static void main(String[] args) {
        // static methods

    }

    @Test
    public void testStaticMethod() {
        IConvert<String, String> convert = Something::startsWith;
        String converted = convert.convert("123");
        System.out.println(converted);
    }

    @Test
    public void testObjectMethod() {

        Something something = new Something();
        IConvert<String, String> converter = something::endWith;
        System.out.println(converter.convert("Java"));
    }
    @Test
    public void testConstructorMethod() {

        IConvert<String, Something> convert = Something::new;
        System.out.println(convert.convert("constructors"));
    }
}
