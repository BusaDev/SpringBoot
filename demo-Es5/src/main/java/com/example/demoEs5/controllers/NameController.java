package com.example.demoEs5.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class NameController {
    @CrossOrigin(origins = {"http://localhost:8080"})
    @GetMapping(path = "/name/{name}")
    public String name(@PathVariable String name){
        return name;
    }
    @CrossOrigin(origins = {"http://localhost:8080"})
    @PostMapping(path = "/reversedname/{name}")
    public StringBuilder reversedName(@PathVariable String name){
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName;
    }
}