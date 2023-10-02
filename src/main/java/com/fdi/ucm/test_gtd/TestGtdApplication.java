package com.fdi.ucm.test_gtd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.fdi.ucm.controller"})
@EntityScan("com.fdi.ucm.model")
@EnableJpaRepositories("com.fdi.ucm.repository")
public class TestGtdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGtdApplication.class, args);
	}

}
