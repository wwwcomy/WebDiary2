package com.iteye.wwwcomy.webdiary2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Webdiary2Application {

	private static Logger logger = LoggerFactory.getLogger(Webdiary2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Webdiary2Application.class, args);
		logger.info("Started, swagger-ui Endpoint: localhost:port/swagger-ui/");
	}

}
