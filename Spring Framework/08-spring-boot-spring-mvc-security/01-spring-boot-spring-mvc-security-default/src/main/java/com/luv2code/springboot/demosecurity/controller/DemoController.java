package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {


    @GetMapping("/")
    public String showhome(){
        return "home";
    }
    @GetMapping("/showMyLoginPage")
    public String loginPage(){
        return "showMyLoginPage";
    }

    @GetMapping("/leaders")
    public String leadersPage(){
        return "leaders";
    }
    @GetMapping("/system")
    public String systemPage(){
        return "System";
    }
    @GetMapping("/access-denied")
    public String denyAccessPage(){
        return "access-denied";
    }

}
