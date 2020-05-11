package com.wildcodeschool.makemehappy.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.repository.AvatarRepository;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
                                 @RequestParam String password,
                                 HttpServletResponse response) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        boolean hasAccount = userRepository.hasAccount(pseudo, sha256hex);

        if (hasAccount) {
            User user = userRepository.getUser(pseudo, sha256hex);
            model.addAttribute("user" , user);

            Cookie cookie = new Cookie("currentId" , Integer.toString(user.getId()));
            /*cookie.setSecure(true);*/
            cookie.setHttpOnly(true);
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
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
    public String showUserProfile(@CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        return "user-profile";
    }

    @PostMapping("/user-profile")
    public String updateUser(Model model,
                           @RequestParam (required = true) String pseudo,
                           @RequestParam (required = true) String password,
                           @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        model.addAttribute("user", userRepository.updateProfile(Integer.parseInt(currentId), pseudo, sha256hex));

        return "dashboard";
    }

    @GetMapping("/disconnected")
    public String logOut(@CookieValue(value = "currentId", defaultValue = "tacos") Cookie cookie,
                         HttpServletResponse response) {

        Cookie newCookie = cookie;
        newCookie.setMaxAge(0);
        newCookie.setHttpOnly(true);
        newCookie.setPath("/");

        response.addCookie(newCookie);
        return "home-page";
    }
}
