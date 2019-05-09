package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/mycontroller")
public class HelloWorldController {

    @RequestMapping(path = "/defaultpage" ,method = RequestMethod.GET)
    //@ResponseBody
    public String getDefaultPage(Model model){
        model.addAttribute("attribute","The Value of the attribute passed from controller");
        return "hello";
    }

}
