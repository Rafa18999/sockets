package edu.rafaelrodriguez.sockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {"edu.rafaelrodriguez.sockets.config",
		"edu.rafaelrodriguez.sockets.controller",
		"edu.rafaelrodriguez.sockets.models",
		"edu.rafaelrodriguez.sockets.services",
})
@EnableMongoRepositories(basePackages = "edu.rafaelrodriguez.sockets.repositories")
public class SocketsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SocketsApplication.class, args);
	}


}


