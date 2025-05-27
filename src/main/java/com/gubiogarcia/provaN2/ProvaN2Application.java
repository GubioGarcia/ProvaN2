package com.gubiogarcia.provaN2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}",
				version = "${info.build.version}",
				description = "${info.app.description}",
				contact = @io.swagger.v3.oas.annotations.info.Contact(
						name = "Resolução avaliação N2 - Gubio Garcia",
						email = "gubiogarcia@gmail.com")))
@SpringBootApplication
public class ProvaN2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProvaN2Application.class, args);
	}

}
