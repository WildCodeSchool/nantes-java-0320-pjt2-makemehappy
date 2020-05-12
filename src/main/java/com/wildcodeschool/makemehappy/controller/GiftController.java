package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
import com.wildcodeschool.makemehappy.model.GiftList;
import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GiftController {

    GiftRepository giftRepository = new GiftRepository();

    @GetMapping("/gift-create")
    public String showGiftCreate() {
        return "gift-create";
    }
    @PostMapping("/gift-create")
    public String postGift(Model out,
                           @RequestParam (required = true) String nameGift,
                           @RequestParam (required = false) String description,
                           @RequestParam (required = false) String urlGiftPicture,
                           @RequestParam (required = false) String urlDealer,
                           @RequestParam (required = true) float price) {


        out.addAttribute("gift", giftRepository.save(nameGift, description, urlGiftPicture, urlDealer, price));

        return "gift-list";
    }
    @GetMapping("/gift-list")
    public String showGiftList(Model out) {
        String pseudo = "Alan";
        out.addAttribute("pseudo", pseudo);

        GiftListRepository giftListRepository = new GiftListRepository();
        GiftList giftList = giftListRepository.findGiftListById(1);
        out.addAttribute("giftList", giftList);

        List<Gift> gifts = new ArrayList<>();
        GiftRepository giftRepository = new GiftRepository();
        gifts = giftRepository.findAllGift();

        out.addAttribute("gifts",gifts);

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