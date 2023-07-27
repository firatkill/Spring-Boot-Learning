package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{



    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
    //define init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("Doing Startup Stuff.");
    }

    //define destroy method
    @PreDestroy
    public void theDestroying(){
        System.out.println("Doing preDestroy stuff.");
    }
}
