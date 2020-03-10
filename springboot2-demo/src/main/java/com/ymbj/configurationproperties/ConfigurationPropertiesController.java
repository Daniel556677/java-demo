package com.ymbj.configurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigurationPropertiesController {

    @Autowired Student student;

    @ResponseBody
    @GetMapping("testConfigurationProperties")
    public Student testConfigurationProperties() {
        return student;
    }
}
