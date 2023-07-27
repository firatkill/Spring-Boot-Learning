package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // @Autowired || field injection can also be made but its not recommended by spring team
    //               due to testing issues.
    private Coach myCoach;

    @Autowired //because of the 'Primary' keyword, soccerCoach has the highest priority.
    public void setcoach(Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/workout")
    public String workout(){
        return this.myCoach.getDailyWorkout();
    }
}
