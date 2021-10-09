package com.simba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan("com.simba.config")
public class ClientServiceApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("oauth2RestTemplate")
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String url = "http://localhost:8082/private";
		String result = restTemplate.getForObject(url, String.class);
		System.out.println("Result == " +result);
	}
}
