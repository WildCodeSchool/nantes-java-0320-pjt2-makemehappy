package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Avatar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/selection-avatar")
    public String chooseYourAvatar(Model model) {

        Avatar avatar1 = new Avatar("boy", "/image/boy.svg");
        Avatar avatar2 = new Avatar("boy-1", "/image/boy-1.svg");
        Avatar avatar3 = new Avatar("girl", "/image/girl.svg");
        Avatar avatar4 = new Avatar("girl-1", "/image/girl-1.svg");
        Avatar avatar5 = new Avatar("man", "/image/man.svg");
        Avatar avatar6 = new Avatar("man-1", "/image/man-1.svg");
        Avatar avatar7 = new Avatar("man-2", "/image/man-2.svg");
        Avatar avatar8 = new Avatar("man-3", "/image/man-3.svg");
        Avatar avatar9 = new Avatar("man-4", "/image/man-4.svg");
        Avatar avatar10 = new Avatar("man-x", "/image/avatar-vide.svg");
        Avatar avatar11 = new Avatar("man-y", "/image/avatar-vide.svg");

        List<Avatar> avatarList = new ArrayList<>();

        avatarList.add(avatar1);
        avatarList.add(avatar2);
        avatarList.add(avatar3);
        avatarList.add(avatar4);
        avatarList.add(avatar5);
        avatarList.add(avatar6);
        avatarList.add(avatar7);
        avatarList.add(avatar8);
        avatarList.add(avatar9);
        avatarList.add(avatar10);
        avatarList.add(avatar11);

        model.addAttribute("avatarList", avatarList);

        return "selection-avatar";
    }
}
