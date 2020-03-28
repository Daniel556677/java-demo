package com.jinyue.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * 这个SPI的demo来自：
 * http://dubbo.apache.org/zh-cn/docs/source_code_guide/dubbo-spi.html
 */
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
