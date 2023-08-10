package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.annotation.Bean;


public class HelloWorldBean {
private String message;
private String name = "Fırat";

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message123='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
