package com.ymbj.autoconfig;


import com.ymbj.hellowolrd.autoconfig.HelloWorldComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	@Autowired
	private HelloWorldComponent helloWorldComponent;

	@RequestMapping("/helloworld")
	@ResponseBody
	private String helloWorld() {
		 return helloWorldComponent.sayHelloWorld();
	}
}
