package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.repository.AvatarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("/selection-avatar")
    public String chooseYourAvatar(Model model) {

        AvatarRepository avatarRepository = new AvatarRepository();

        List<Avatar> avatarList = avatarRepository.findAll();

        model.addAttribute("avatarList", avatarList);

        return "selection-avatar";
    }
}
