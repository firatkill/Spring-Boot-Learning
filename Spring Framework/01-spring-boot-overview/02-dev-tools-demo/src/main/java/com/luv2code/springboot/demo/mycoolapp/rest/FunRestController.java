package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;


    @GetMapping("/naber")
    public String Naber(){
        return "Naber";
    }
    @GetMapping("/")
    public String HelloWorld(){
        return coachName;

    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "didn't run a hard 5k!";
    }


}
