package com.example.Deploy_Es1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Controller {
    @Autowired
    private Environment environment;

    @GetMapping
    public String devName(){
        String name = environment.getProperty("devName");
        return name;
    }
}
