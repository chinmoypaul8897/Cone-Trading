package com.cone.trading.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String home()
    {
        return "Welcome to cone trading ";
    }

    @GetMapping("/api")
    public String secure()
    {
        return "Welcome to cone trading - > Secure and Safe ";
    }
}
