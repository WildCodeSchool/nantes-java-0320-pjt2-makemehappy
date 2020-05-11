package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ListController {

    GiftListRepository giftListRepository = new GiftListRepository();

    @GetMapping("/list-create")
    public String showListCreate() {
        return "list-create";
    }

    @PostMapping("/list-create")
    public String postList(Model out,
                           @RequestParam(required = true) String title,
                           @RequestParam (required = true) int idTheme,
                           @RequestParam (required = false) Date deadLine,
                           @RequestParam (required = false) String description)
                           {

        // faire la méthode save de GiftListRepository
        //out.addAttribute("gift", giftListRepository.save(title, deadLine, description, idTheme);

        return "list-create";
    }

}
