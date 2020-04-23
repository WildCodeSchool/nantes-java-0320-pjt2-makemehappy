package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GiftController {

    @GetMapping("/gift-create")
    public String showGiftCreate() {
        return "gift-create";
    }

    @GetMapping("/gift-list")
    public String showGiftList() {

        return "gift-list";
    }
    @GetMapping("/gift")
    public String showGift() {
        return "gift";
    }

    @GetMapping("/gift-user-reserved")
    public String showGiftUserReserved() {
        return "gift-user-reserved";
    }

}
