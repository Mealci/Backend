package com.mealci.core.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "This is a public endpoint";
    }

    @GetMapping("/secured")
    public String secured() {
        return "This is a secured endpoint";
    }
}