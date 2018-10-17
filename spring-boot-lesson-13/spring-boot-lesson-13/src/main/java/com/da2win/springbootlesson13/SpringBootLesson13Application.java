package com.da2win.springbootlesson13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

@SpringBootApplication
@EnableWebSocket
public class SpringBootLesson13Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson13Application.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	@Bean
	public ChatRoomServerEndpoint chatRoomServerEndpoint() {
		return new ChatRoomServerEndpoint();
	}
}
