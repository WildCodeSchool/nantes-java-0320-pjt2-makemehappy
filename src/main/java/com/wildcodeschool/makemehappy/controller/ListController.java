package com.wildcodeschool.makemehappy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list-create")
    public String showListCreate() {

        return "list-create";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {

        return "dashboard-empty";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

}
