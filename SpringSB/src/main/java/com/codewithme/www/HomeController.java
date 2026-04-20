package com.codewithme.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        if(username.equals("admin") && password.equals("1234")) {
            return "home";
        }

        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
