package com.da2win.springbootlesson18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:META-INF/spring/context.xml"})
public class SpringBootLesson18Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson18Application.class, args);
	}
}
