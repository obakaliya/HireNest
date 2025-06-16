package com.api;

import java.security.NoSuchAlgorithmException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    SpringApplication.run(Application.class, args);
  }
}
