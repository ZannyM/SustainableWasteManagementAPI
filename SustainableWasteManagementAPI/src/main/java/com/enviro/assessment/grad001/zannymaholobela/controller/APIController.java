package com.enviro.assessment.grad001.zannymaholobela.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Sustainable waste application!";
    }
}
