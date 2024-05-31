package com.example.Middleware_Es1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/time")
public class BasicController {
    @GetMapping
    public Date data(){
        return new Date();
    }
}
