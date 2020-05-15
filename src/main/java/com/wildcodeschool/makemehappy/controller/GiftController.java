package com.wildcodeschool.makemehappy.controller;


import com.wildcodeschool.makemehappy.entity.UserGift;
import com.wildcodeschool.makemehappy.entity.User;
import com.wildcodeschool.makemehappy.model.Gift;
import com.wildcodeschool.makemehappy.model.GiftList;
import com.wildcodeschool.makemehappy.repository.GiftListRepository;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import com.wildcodeschool.makemehappy.repository.UserGiftRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import com.wildcodeschool.makemehappy.repository.UserRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GiftController {

    GiftRepository giftRepository = new GiftRepository();

    @GetMapping("/gift-create")
    public String showGiftCreate(Model out,
                                 @CookieValue(value = "currentId", defaultValue = "tacos") String currentId,
                                 @RequestParam (required = true) int idGiftList) {

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());
        out.addAttribute("idGiftList", idGiftList);
        return "gift-create";
    }
    @PostMapping("/gift-create")
    public String postGift(Model out,
                           @RequestParam (required = true) String nameGift,
                           @RequestParam (required = false) String description,
                           @RequestParam (required = false) String urlGiftPicture,
                           @RequestParam (required = false) String urlDealer,
                           @RequestParam (required = true) float price,
                           @RequestParam (required = false, defaultValue = "1") Integer note,
                           @RequestParam (required = true) int idGiftList) {

        out.addAttribute("gift", giftRepository.save(nameGift, description, urlGiftPicture, urlDealer, price, note, idGiftList));
        return "redirect:/gift-list?id="+idGiftList;
    }

    @GetMapping("/modification-gift")
    public String getGiftUpdate(Model out,
                                @RequestParam int id,
                                @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        out.addAttribute("giftModif", giftRepository.findById(id));

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());

        return "modification-gift";
    }

    @PostMapping("/modification-gift")
    public String postGiftUpdate(Model out,
                           @RequestParam (required = false) int id,
                           @RequestParam (required = true) String nameGift,
                           @RequestParam (required = false) String description,
                           @RequestParam (required = false) String urlGiftPicture,
                           @RequestParam (required = false) String urlDealer,
                           @RequestParam (required = true) float price,
                                 @RequestParam (required = false, defaultValue = "1") Integer note) {


        out.addAttribute("giftModif", giftRepository.update(id, nameGift, description, urlGiftPicture, urlDealer, price, note));

        return "redirect:/dashboard";
    }

    @GetMapping("/gift-list")
    public String showGiftList(Model out,
                               @RequestParam int id,
                               @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        String pseudo = "Alan";
        out.addAttribute("pseudo", pseudo);

        GiftListRepository giftListRepository = new GiftListRepository();
        GiftList giftList = giftListRepository.findGiftListById(id);
        out.addAttribute("giftList", giftList);

        List<Gift> gifts = new ArrayList<>();
        GiftRepository giftRepository = new GiftRepository();
        gifts = giftRepository.findAllGiftById(id);
        out.addAttribute("gifts",gifts);

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());

        return "gift-list";
    }


    @GetMapping("/gift")
    public String showGift(Model out,
                           @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {
        String pseudo = "Bastien";
        out.addAttribute("pseudo", pseudo);
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());
        return "gift";
    }

    @GetMapping("/gift-user-reserved")
    public String showGiftUserReserved(Model out,
                                      @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) throws SQLException {

        GiftRepository giftrepository = new GiftRepository();
        Gift gift = giftrepository.findGift();
        out.addAttribute("giftDetails", gift);

        UserGiftRepository userGiftRepository= new UserGiftRepository();
        UserGift userGift = userGiftRepository.findUserGift();
        out.addAttribute("userGift", userGift);

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());
        return "gift-user-reserved";
    }

    @GetMapping("/gift-visitor-resa-connected")
    public String showGiftVisitorResaConnected(Model out,
                                               @CookieValue(value = "currentId", defaultValue = "tacos") String currentId) {

        GiftRepository repository = new GiftRepository();
        Gift gift = repository.findGift();
        out.addAttribute("giftDetails", gift);
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserById(Integer.parseInt(currentId));
        out.addAttribute("avatarUrl", user.getAvatar());
        return "gift-visitor-resa-connected";
    }

    @PostMapping("/delete-gift")
    public String deleteGift(@RequestParam int idGift) {
        giftRepository.deleteById(idGift);
        return "redirect:/gift-list";
    }
}