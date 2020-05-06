package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiftController {

    @GetMapping("/gift-create")
    public String showGiftCreate() {
        return "gift-create";
    }

    @GetMapping("/gift-list")
    public String showGiftList(Model out) {
        String pseudo = "Alan";
        out.addAttribute("pseudo", pseudo);

        List<Gift> gifts = new ArrayList<>();
        Gift gift1 = new Gift(1, "castor", 30, 3, "https://www.mynoors.com/peluche-castor-30-cm.html","https://ressources.mynoors.com/files/pages/original/2018/10/21/ryngot-castoro-l-30-cm-2396.jpg", "en peluche", 1);
        Gift gift2 = new Gift(2, "poussin", 30, 5, "https://www.mynoors.com/peluche-castor-30-cm.html","https://ressources.mynoors.com/files/pages/original/2018/10/21/ryngot-castoro-l-30-cm-2396.jpg", "en peluche", 1);
        Gift gift3 = new Gift(3, "lapin", 30, 1, "https://www.mynoors.com/peluche-castor-30-cm.html","https://ressources.mynoors.com/files/pages/original/2018/10/21/ryngot-castoro-l-30-cm-2396.jpg", "en peluche", 1);

        gifts.add(gift1);
        gifts.add(gift2);
        gifts.add(gift3);

        out.addAttribute("listGift", gifts);

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

        GiftRepository repository = new GiftRepository();
        Gift gift = repository.findGift();
        out.addAttribute("giftDetails", gift);

        return "gift-visitor-resa-connected";
    }

}
