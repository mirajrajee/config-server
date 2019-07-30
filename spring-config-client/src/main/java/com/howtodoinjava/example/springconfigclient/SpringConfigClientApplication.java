package com.howtodoinjava.example.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(APConfig.class)
public class SpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController

class MessageRestController {

		@Autowired
	private APConfig apConfig;

	@RequestMapping("/msg")
	String getMsg() throws InterruptedException {
		Map<String, Map<String, String>> config = apConfig.getGreatings();
		String english = config.get("english").get("good_night");
		return english ;
	}
}
