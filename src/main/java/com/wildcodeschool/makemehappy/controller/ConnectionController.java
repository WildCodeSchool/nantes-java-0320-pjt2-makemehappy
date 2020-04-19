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
    public String showConnectionPage() {

        return "home-page";
    }

    @GetMapping("/new-profile")
    public String showNewProfilPage() {

        return "home-page";
    }
}
