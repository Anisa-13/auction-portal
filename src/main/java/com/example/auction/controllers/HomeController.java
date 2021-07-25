package com.example.auction.controllers;

import com.example.auction.service.auction.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    protected final AuctionService auctionService;

    public HomeController(final AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("currentAuctions", auctionService.getCurrentAuctions());
        return "index";
    }

}
