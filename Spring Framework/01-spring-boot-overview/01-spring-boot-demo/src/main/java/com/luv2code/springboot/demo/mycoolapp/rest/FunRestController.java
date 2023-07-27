package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/naber")
    public String Naber(){
        return "Naber!";
    }
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World!";

    }
    @GetMapping("/isupdated")
    public String isupdated(){
        return "is it updating?";
    }


}
