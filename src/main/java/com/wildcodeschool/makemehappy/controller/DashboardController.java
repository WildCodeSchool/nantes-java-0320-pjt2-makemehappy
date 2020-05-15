package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.model.GiftList;
import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard (Model model,
                                 @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        GiftListRepository repository = new GiftListRepository();
        List<GiftList> dashboard = repository.findAllWishList(Integer.parseInt(currentId));
        model.addAttribute("dashboard", dashboard);

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        model.addAttribute("avatarUrl",user.getAvatar());
        return "dashboard";
    }

    @GetMapping("/dashboard-empty")
    public String showDashboardEmpty() {
        return "dashboard-empty";
    }

}
