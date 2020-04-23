package com.wildcodeschool.makemehappy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectionController {

    @GetMapping("/")
    public String showHomePage() {

        return "home-page";
    }

    @GetMapping("/connection")
    public String showConnection() {

        return "connection";
    }

    @GetMapping("/new-profile")
    public String showNewProfile() {

        return "new-profile";
    }

    @GetMapping("/user-profile")
    public String showUserProfile() {

        return "user-profile";
    }
}
