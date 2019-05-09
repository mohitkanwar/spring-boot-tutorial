package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/mycontroller")
public class HelloWorldController {

    @RequestMapping(path = "/defaultpage" ,method = RequestMethod.GET)
    public String getDefaultPage(Model model){
        model.addAttribute("attribute","The Value of the attribute passed from controller");
        return "hello";
    }

    @RequestMapping(path = "/specialpage" ,method = RequestMethod.GET)
    public ModelAndView getSpecailPage(@RequestParam(name = "message", required = false)String message){
        ModelAndView modelAndView = new ModelAndView("special");
        message = message==null?"The Value of the attribute passed from ModelAndView":message;
        modelAndView.addObject("attribute",message);
        return modelAndView;
    }

    /**
     * Common Model Attributes injected in all views
     * @return
     */
    @ModelAttribute("messages")
    public List<String> messages() {
        List<String> messages = new ArrayList<>();
        messages.add("This is first Message");
        messages.add("This is Second Message");
        return messages;
    }

}
