package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach myCoach;


    @Autowired
    public void setcoach(@Qualifier("cricketCoach") Coach theCoach){
        myCoach=theCoach;

    }




    @GetMapping("/workout")
    public String workout(){
        return this.myCoach.getDailyWorkout();
    }

}
