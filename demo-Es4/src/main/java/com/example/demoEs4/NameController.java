package com.example.demoEs4;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class NameController {
    @GetMapping(path = "/name/{name}")
    public String name(@PathVariable String name){
        return name;
    }

    @PostMapping(path = "/reversedname/{name}")
    public StringBuilder reversedName(@PathVariable String name){
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName;
    }
}
