package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

//(exclude={SecurityAutoConfiguration.class})
//@EnableJpaRepositories

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

