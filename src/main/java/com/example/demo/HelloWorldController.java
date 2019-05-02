package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mycontroller")
public class HelloWorldController {

    //http://localhost:8080/mycontroller/english/defaultpage?name=Dunia
    @RequestMapping(path = "/{locale}/defaultpage" ,method = RequestMethod.GET)
    //@ResponseBody
    public String getDefaultPage(@RequestParam(name = "name",required = false, defaultValue = "World") String name,
                                 @PathVariable(name = "locale") String locale){
        return "hello " +name+". The chosen locale is "+locale;
    }

}
