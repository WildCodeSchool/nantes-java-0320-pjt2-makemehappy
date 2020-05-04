package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.repository.AvatarRepository;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    UserRepository userRepository = new UserRepository();

    @GetMapping("/connection")
    public String showConnection() {

        return "connection";
    }

    @PostMapping("/connection")
    public String userConnection(Model model,
                                 @RequestParam String pseudo,
                                 @RequestParam String password) {

        boolean hasAccount = userRepository.hasAccount(pseudo, password);

        if (hasAccount) {
            User user = userRepository.getUser(pseudo, password);
            model.addAttribute("user" , user);
        } else {
            return "/connection";
        }

        return "dashboard";
    }

    @GetMapping("/selection-avatar")
    public String chooseYourAvatar(Model model) {

        AvatarRepository avatarRepository = new AvatarRepository();

        List<Avatar> avatarList = avatarRepository.findAll();

        model.addAttribute("avatarList", avatarList);

        return "selection-avatar";
    }
}
