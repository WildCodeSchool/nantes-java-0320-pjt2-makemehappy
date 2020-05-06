package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.GiftList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard (Model model) {

        GiftList list1= new GiftList();
        GiftList list2= new GiftList();
        GiftList list3= new GiftList();

        list1.setTitle("Anniversaire");
        list2.setTitle("Noel");
        list3.setTitle("Boom chez Ganout");

        List<GiftList> dashboardLift = new ArrayList<>();

        dashboardLift.add(list1);
        dashboardLift.add(list2);
        dashboardLift.add(list3);

        model.addAttribute("list", dashboardLift);
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
