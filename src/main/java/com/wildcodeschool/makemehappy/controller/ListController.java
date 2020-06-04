package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class ListController {

    @Autowired
    private GiftListRepository giftListRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list-create")
    public String showListCreate(Model out,
                                 @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());
        return "list-create";
    }

    @PostMapping("/list-create")
    public String postList(Model out,
                           @RequestParam(required = true) String title,
                           @RequestParam(required = false, defaultValue = "1") int idTheme,
                           @RequestParam(required = false) Date deadLine,
                           @RequestParam(required = false) String description,
                           @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        out.addAttribute("giftList", giftListRepository.save(title, idTheme, deadLine, description, Integer.parseInt(currentId)));

        return "redirect:/dashboard";
    }


    @PostMapping("/delete-wishlist")
    public String deleteWishList(@RequestParam int idGiftList) {
        giftListRepository.deleteById(idGiftList);
        return "redirect:/dashboard";
    }
}
