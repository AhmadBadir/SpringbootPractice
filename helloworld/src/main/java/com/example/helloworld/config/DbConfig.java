package com.example.helloworld.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
  public DbConfig() {}

  public String helloworldConfig() {
    return "Hello World from config!!";
  }
}
