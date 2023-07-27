package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void setcoach(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach anotherCoach){
        myCoach=theCoach;
        this.anotherCoach=anotherCoach;
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach" + (myCoach==anotherCoach);
    }


    @GetMapping("/workout")
    public String workout(){
        return this.myCoach.getDailyWorkout();
    }

}
