package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionController {
    @GetMapping("/auction")
    public String getBuy(){
        return "auctions";

    }

}
