package com.sb.appsync;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsappsyncToSpringbootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AwsappsyncToSpringbootDemoApplication.class, args);
	}

	@Autowired
	ClientConnector clientConnector;

	@PostConstruct
	public void getUser() {
		clientConnector.getUSerDetailsFromAWSAppSync();
	}

}
