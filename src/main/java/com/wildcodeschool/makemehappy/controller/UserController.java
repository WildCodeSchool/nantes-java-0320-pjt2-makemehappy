package com.wildcodeschool.makemehappy.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.entity.Avatar;
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

        return "redirect:/dashboard";
    }

    @GetMapping("/create-profile")
    public String showNewProfile() {

        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createUser(Model model,
                             @RequestParam (required = true) String pseudo,
                             @RequestParam (required = true) String password,
                             @RequestParam (required = false, defaultValue = "image/avatar-vide.svg") String avatar,
                             HttpServletResponse response) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        boolean hasAccount = userRepository.hasAccount(pseudo, sha256hex);

        if (!hasAccount) {
            User user = userRepository.createUser(pseudo, sha256hex, avatar);
            model.addAttribute("user" , user);
            Cookie cookie = new Cookie("currentId" , Integer.toString(user.getId()));
            /*cookie.setSecure(true);*/
            cookie.setHttpOnly(true);
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            model.addAttribute("user", user);
        } else {
            return "/connection";
        }
        return "redirect:/selection-avatar";
    }

    @GetMapping("/selection-avatar")
    public String chooseYourAvatar(Model model,
                                   @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        User user = userRepository.getUserById(Integer.parseInt(currentId));
        AvatarRepository avatarRepository = new AvatarRepository();

        List<Avatar> avatarList = avatarRepository.findAll();

        model.addAttribute("avatarList", avatarList);
        model.addAttribute("avatarUrl", user.getAvatar());

        return "selection-avatar";
    }

    @PostMapping("/selection-avatar")
    public String saveAvatar(@RequestParam int idAvatar,
                             @RequestParam String nameAvatar,
                             @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        userRepository.updateAvatar(Integer.parseInt(currentId), idAvatar, nameAvatar);

        return "redirect:/dashboard";
    }

    @GetMapping("/user-profile")
    public String showUserProfile(Model model,
                                  @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        User currentUser = userRepository.getUserById(Integer.parseInt(currentId));
        model.addAttribute("currentUser", currentUser);
        return "user-profile";
    }

    @PostMapping("/user-profile")
    public String updateUser(Model model,
                           @RequestParam (required = true) String pseudo,
                           @RequestParam (required = true) String password,
                           @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        model.addAttribute("user", userRepository.updateProfile(Integer.parseInt(currentId), pseudo, sha256hex));

        return "redirect:/dashboard";
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
