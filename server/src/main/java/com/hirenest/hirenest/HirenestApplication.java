package com.hirenest.hirenest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class HirenestApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(HirenestApplication.class, args);
	}

}