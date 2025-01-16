package com.example.helloworld.controller;

import com.example.helloworld.config.HelloWorldConfig;
import com.example.helloworld.service.HelloWorldServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

  private final HelloWorldServiceImpl helloService;
  private final HelloWorldConfig helloConfig;

  public HelloWorldController(HelloWorldServiceImpl helloService, HelloWorldConfig helloConfig) {
    this.helloService = helloService;
    this.helloConfig = helloConfig;
  }

  @GetMapping("/helloworld")
  public ResponseEntity<String> getHelloworld() {
    return ResponseEntity.ok(helloService.helloworld());
  }
}
