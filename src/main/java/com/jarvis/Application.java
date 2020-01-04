package com.jarvis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import com.jarvis.entity.AppUser;
import com.jarvis.service.UserService;

@SpringBootApplication
@ImportResource({"eventMessageRouter.xml","batchMessageRouter.xml","communicationMessageRouter.xml"})
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	UserService userService;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("Checking if user exist");
		if (null != userService.findByUsername("admin")) {
			logger.info("User already exist");
		} else {
			logger.info("Creating user");
			AppUser user = new AppUser();
			user.setPassword("admin");
			user.setUsername("admin");
			userService.save(user);
		}
	}

}
