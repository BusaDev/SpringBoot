package com.example.demoEs1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class Controller {
@GetMapping(path = "/ciao/{provincia}")
    public User helloWorld(
            @PathVariable String provincia,
            @RequestParam String nome){
        return new User(nome, provincia);
    }
}
