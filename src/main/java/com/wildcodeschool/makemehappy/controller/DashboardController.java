package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.GiftList;
import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard (Model model) {

        GiftListRepository repository = new GiftListRepository();
        List<GiftList> dashboard = repository.findAllWishList();
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
