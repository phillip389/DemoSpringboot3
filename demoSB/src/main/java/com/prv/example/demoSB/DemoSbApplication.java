package com.prv.example.demoSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({SBConfiguration.class})
public class DemoSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbApplication.class, args);
	}

}
