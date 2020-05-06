package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
import com.wildcodeschool.makemehappy.repository.GiftRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        Gift gift1 = new Gift(1, "casque", 30, 4, "https://www.amazon.fr/Casque-filaire-BEATS-DR-DRE-Beats/dp/B07CNQ1CWS","https://images-na.ssl-images-amazon.com/images/I/41O-eL-JDJL._AC_SY450_.jpg", "sans fil", 1);
        Gift gift2 = new Gift(2, "ecran", 9499, 3, "https://www.boulanger.com/ref/1123090","https://boulanger.scene7.com/is/image/Boulanger/4718017169349_h_f_l_0?wid=400&hei=270", "écran gamer incurvé", 3);
        Gift gift3 = new Gift(3, "xbox", 499, 5, "https://www.xbox.com/fr-FR/consoles/xbox-one-x/star-wars-jedi-fallen-order-1tb","https://compass-ssl.xbox.com/assets/c6/6b/c66b3c27-0c9c-4ee6-9243-869675526a74.jpg?n=X1X-993554_Content-Placement-0_Console-hub_740x417_02.jpg", "pack console plus jeu", 3);

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
