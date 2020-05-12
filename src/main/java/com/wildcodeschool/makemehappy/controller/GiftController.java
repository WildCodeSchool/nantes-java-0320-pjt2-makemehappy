package com.wildcodeschool.makemehappy.controller;

import com.wildcodeschool.makemehappy.model.Gift;
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
                           @RequestParam (required = true) float price,
                           @RequestParam (required = false, defaultValue = "1") Integer note) {


        out.addAttribute("gift", giftRepository.save(nameGift, description, urlGiftPicture, urlDealer, price, note));

        return "gift-list";
    }

    @GetMapping("/modification-gift")
    public String getGiftUpdate(Model out,
                                @RequestParam int id) {

        out.addAttribute("giftModif", giftRepository.findById(id));


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

        return "modification-gift";
    }



    @GetMapping("/gift-list")
    public String showGiftList(Model out) {
        String pseudo = "Alan";
        out.addAttribute("pseudo", pseudo);

        List<Gift> gifts = new ArrayList<>();
        Gift gift3 = new Gift(3, "casque", 60, 3, "https://www.cdiscount.com/high-tech/casques-baladeur-hifi/casque-filaire-beats-by-dr-dre-beats-solo-hd-ver/f-1065420-bea0709885231454.html","https://www.cdiscount.com/pdt2/4/5/4/1/700x700/bea0709885231454/rw/casque-filaire-beats-by-dr-dre-beats-solo-hd-ver.jpg", "filaire", 3);
        Gift gift4 = new Gift(4, "ecran", 9499, 5, "https://www.boulanger.com/ref/1123090","https://boulanger.scene7.com/is/image/Boulanger/4718017169349_h_f_l_0?wid=400&hei=270", "écran gamer incurvé", 4);
        Gift gift5 = new Gift(5, "xbox", 499, 1, "https://www.xbox.com/fr-FR/consoles/xbox-one-x/star-wars-jedi-fallen-order-1tb","https://compass-ssl.xbox.com/assets/c6/6b/c66b3c27-0c9c-4ee6-9243-869675526a74.jpg?n=X1X-993554_Content-Placement-0_Console-hub_740x417_02.jpg", "pack console plus jeu", 5);

        gifts.add(gift3);
        gifts.add(gift4);
        gifts.add(gift5);

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