package com.example.simpleservermaven;

import com.example.simpleservermaven.services.TaskService;
import com.example.simpleservermaven.services.TaskServiceImpl;
import com.example.simpleservermaven.services.TaskServiceTestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleservermavenApplication {
	private static boolean isTestEnv = false;
	public static void main(String[] args) {
		if (args[0].equals("test")) {
			isTestEnv = true;
		}
		SpringApplication.run(SimpleservermavenApplication.class, args);
	}

	@Bean
	public TaskService taskService() {
		if (!isTestEnv) {
			return new TaskServiceImpl();
		} else {
			return new TaskServiceTestImpl();
		}
	}



}
