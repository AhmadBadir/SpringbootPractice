package com.example.helloworld.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class HelloWorldServiceImpl  {

  public String helloworld() {
    return "Hello World from service!!";
  }
}
