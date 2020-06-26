package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
   
  }
}