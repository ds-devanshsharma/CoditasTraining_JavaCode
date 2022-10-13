package com.RESTcarpassenger.RESTCarpassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RestCarPassengerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestCarPassengerApplication.class, args);
	}

}
