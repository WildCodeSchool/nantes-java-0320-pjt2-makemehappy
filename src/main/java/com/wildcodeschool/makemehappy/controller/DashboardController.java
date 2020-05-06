package com.wildcodeschool.makemehappy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String showDashboard (Model model) {
        String pseudo =  "Donkey";
        model.addAttribute("pseudo", pseudo);

        List<List> lists = new ArrayList<>();

        List list1 = new List();

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        model.addAttribute("names", names);
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
