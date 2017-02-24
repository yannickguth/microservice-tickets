package de.cluster.microservices.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.cluster.microservices.tickets"} )
public class MicroserviceTicketsApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceTicketsApplication.class, args);
	}
}
