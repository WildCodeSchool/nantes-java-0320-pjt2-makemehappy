package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GiftController {

    @GetMapping("/gift-create")
    public String showGiftCreate() {
        return "gift-create";
    }

    @GetMapping("/gift-list")
    public String showGiftList(Model out) {
        String pseudo = "Anne";
        out.addAttribute("pseudo", pseudo);

        return "gift-list";
    }


    @GetMapping("/gift")

    public String showGift(Model out) {
        String pseudo = "Bastien";
        out.addAttribute("pseudo", pseudo);


        return "gift";
    }

    @GetMapping("/gift-user-reserved")
    public String showGiftUserReserved() {

        return "gift-user-reserved";
    }

    @GetMapping("/gift-visitor-resa-connected")
    public String showGiftVisitorResaConnected(Model out) {

        Gift gift = new Gift ( "Casque", 200.00, 3, "https://www.backmarket.fr/casque-reducteur-de-bruit-bluetooth-avec-micro-beats-studio3-wireless-noir-pas-cher/89869.html#?l=0", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Headphones_1.jpg/1200px-Headphones_1.jpg",
                "j'en rêve la nuit!, il me le faut absolment!");
        out.addAttribute("giftDetails", gift);

        return "gift-visitor-resa-connected";
    }

}
