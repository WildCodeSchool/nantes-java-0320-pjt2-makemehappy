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

        GiftList giftList1 = new GiftList();
        GiftList giftList2 = new GiftList();
        GiftList giftList3 = new GiftList();

        giftList1.setTitle("Anniversaire");
        giftList2.setTitle("Noel");
        giftList3.setTitle("Boom chez Ganout");

        List<GiftList> dashboardList = new ArrayList<>();

        dashboardList.add(giftList1);
        dashboardList.add(giftList2);
        dashboardList.add(giftList3);

        model.addAttribute("dashboard", dashboardList);
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
