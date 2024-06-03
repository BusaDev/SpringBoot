package com.example.Deploy_Es2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class Controller {
    @GetMapping("/sum")
    public int getSum() {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        return a + b;
    }
}
