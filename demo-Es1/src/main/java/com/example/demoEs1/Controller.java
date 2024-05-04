package com.example.demoEs1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Controller {
@GetMapping(path = "/ciao")
    public String helloWorld(@RequestParam String nome, @RequestParam String provincia){
        return "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
    }
}
