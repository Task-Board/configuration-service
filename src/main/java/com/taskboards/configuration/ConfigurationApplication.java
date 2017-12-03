package com.taskboards.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//TODO: bus/rabbitmq
@EnableConfigServer
@SpringBootApplication
public class ConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}
}
