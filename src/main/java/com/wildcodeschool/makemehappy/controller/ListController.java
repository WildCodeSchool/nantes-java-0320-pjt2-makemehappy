package com.wildcodeschool.makemehappy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list-create")
    public String showListCreate() {

        return "list-create";
    }

<<<<<<< HEAD
=======
    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {

        return "dashboard-empty";
    }
>>>>>>> 469762f289705aa51bd1e16736a5b5e0da48fd00


}
