package com.quicktutorials.learnmicroservices.accountmicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountmicroserviceApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(AccountmicroserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountmicroserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Hello 1");
	}
}
