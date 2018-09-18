package com.da2win.springbootlesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.da2win.springbootlesson8")
public class SpringBootLesson8Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson8Application.class, args);
	}
}
