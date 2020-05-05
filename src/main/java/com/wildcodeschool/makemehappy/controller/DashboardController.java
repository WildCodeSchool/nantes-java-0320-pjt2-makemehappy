package com.wildcodeschool.makemehappy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String showDashboard (Model model) {
        String name =  "Donkey";
        model.addAttribute("name", name);
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
