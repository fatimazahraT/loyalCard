package com.example.app.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class Democontroller {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello from secured endpoint");
    }
}
