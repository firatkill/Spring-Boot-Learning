package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // in use for When there is multiple injection problem, this coach class will have the highest priority.
public class SoccerCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "play Soccer 1 hour.";
    }
}
