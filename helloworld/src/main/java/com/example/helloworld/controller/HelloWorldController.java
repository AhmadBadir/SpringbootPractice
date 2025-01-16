package com.example.helloworld.controller;


import com.example.helloworld.service.HelloWorldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    private final HelloWorldServiceImpl helloService;

    public HelloWorldController(HelloWorldServiceImpl helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/helloworld")
    public ResponseEntity<String>  getHelloworld () {
        return ResponseEntity.ok(helloService.helloworld());
    }
}
