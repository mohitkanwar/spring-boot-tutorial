package com.example.demo;

import com.example.demo.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tdd/")
public class HelloWorldController {

    @Autowired
    private Translator englishTranslator;

    @GetMapping("helloworld")
    public DataResponse greetHello(
            @RequestParam(name = "name", defaultValue = "World", required = false)String name){
        return new DataResponse("Hello "+name+"!");
    }

    @GetMapping("{locale}/helloworld")
    public DataResponse greetHelloLocaleSpecific(@PathVariable(name = "locale") String locale){
        return new DataResponse(englishTranslator.getTranslatedValue("Hello World!",locale));
    }
}
