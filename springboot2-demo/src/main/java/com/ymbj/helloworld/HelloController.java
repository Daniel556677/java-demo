package com.ymbj.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
