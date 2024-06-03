package com.example.Deploy_Es3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class controller {
    @Autowired
    private Environment environment;

    @GetMapping
    public String greetings(){
        String greetings = environment.getProperty("devName") +" "+ environment.getProperty("authCode");
        return greetings;
    }
}
