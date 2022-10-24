package com.joseneyra.sfmsbrewery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SfMsBreweryApplication {

	public static void main(String[] args) {

		log.info("Application started");
		SpringApplication.run(SfMsBreweryApplication.class, args);
	}

}
