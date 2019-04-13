package com.example.demo;

import com.example.demo.response.DataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tdd/")
public class HelloWorldController {

    @GetMapping("helloworld")
    public DataResponse greetHello(
            @RequestParam(name = "name", defaultValue = "World", required = false)String name){
        return new DataResponse("Hello "+name+"!");
    }
}
