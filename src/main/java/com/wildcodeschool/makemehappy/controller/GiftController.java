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

    @GetMapping("/gift")
    public String showGift() {
        return "gift";
    }


}
