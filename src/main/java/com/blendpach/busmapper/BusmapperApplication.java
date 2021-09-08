package com.blendpach.busmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BusmapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusmapperApplication.class, args);
	}

}
