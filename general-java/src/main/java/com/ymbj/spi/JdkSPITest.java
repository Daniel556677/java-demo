package com.ymbj.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * JdkSPITest：
 */
public class JdkSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Developer> serviceLoader = ServiceLoader.load(Developer.class);
        serviceLoader.forEach(Developer::sayHi);
    }
}
