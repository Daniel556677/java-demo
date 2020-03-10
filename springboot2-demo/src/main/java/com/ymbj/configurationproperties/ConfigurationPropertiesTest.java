package com.ymbj.configurationproperties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// TODO:这是个未调试成功的案例
@EnableConfigurationProperties(Student.class)
public class ConfigurationPropertiesTest {
    @Autowired Student student;
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    @Test
    public void testConfigurationProperties() {
        System.out.println(student);
    }

}
