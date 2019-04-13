package com.example.demo;

import com.example.demo.response.DataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tdd/")
public class HelloWorldController {

    @GetMapping("helloworld")
    public DataResponse greetHello(){
        return new DataResponse("Hello World!");
    }
}
