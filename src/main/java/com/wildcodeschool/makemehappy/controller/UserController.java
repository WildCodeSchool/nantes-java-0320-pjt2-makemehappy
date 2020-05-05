package com.wildcodeschool.makemehappy.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.repository.AvatarRepository;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class UserController {

    UserRepository userRepository = new UserRepository();

    @GetMapping("/")
    public String showHomePage() {

        return "home-page";
    }

    @GetMapping("/connection")
    public String showConnection() {

        return "connection";
    }

    @PostMapping("/connection")
    public String userConnection(Model model,
                                 @RequestParam String pseudo,
                                 @RequestParam String password) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        boolean hasAccount = userRepository.hasAccount(pseudo, sha256hex);

        if (hasAccount) {
            User user = userRepository.getUser(pseudo, sha256hex);
            model.addAttribute("user" , user);
        } else {
            return "/connection";
        }

        return "dashboard";
    }

    @GetMapping("/create-profile")
    public String showNewProfile() {

        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createUser(Model model,
                             @RequestParam (required = true) String pseudo,
                             @RequestParam (required = true) String password) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        model.addAttribute("user", userRepository.createUser(pseudo, sha256hex));

        return "dashboard-empty";
    }

    @GetMapping("/selection-avatar")
    public String chooseYourAvatar(Model model) {

        AvatarRepository avatarRepository = new AvatarRepository();

        List<Avatar> avatarList = avatarRepository.findAll();

        model.addAttribute("avatarList", avatarList);

        return "selection-avatar";
    }

    @GetMapping("/user-profile")
    public String showUserProfile() {

        return "user-profile";
    }

    @PostMapping("/user-profile")
    public User updateUser(Model model,
                           @RequestParam (required = true) int id,
                           @RequestParam (required = true) String pseudo,
                           @RequestParam (required = true) String password) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        model.addAttribute("user", userRepository.updateProfile(id, pseudo, sha256hex));

        User user = new User();
        return user;
    }
}
