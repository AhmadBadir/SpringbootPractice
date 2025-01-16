package com.example.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
  public HelloWorldConfig() {}

  @Bean
  public String helloworldConfig() {
    return "Hello World from config!!";
  }
}
