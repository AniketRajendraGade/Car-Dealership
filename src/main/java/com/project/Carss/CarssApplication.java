package com.project.Carss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({FileStorageproperties.class})
public class CarssApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarssApplication.class, args);
	}

}
