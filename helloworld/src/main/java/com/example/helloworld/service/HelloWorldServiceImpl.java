package com.example.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HellowWorldService {

  public HelloWorldServiceImpl() {}

  public String helloworld() {
    return "Hello World from service!!";
  }
}
