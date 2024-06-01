package com.example.Middleware_Es2.Controllers;

import com.example.Middleware_Es2.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/month")
public class MonthController {

    @GetMapping
    public Month getMonth(@RequestAttribute("monthNumber") Month month) {
        return month;
    }
}
