package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyController {
    @GetMapping("/buy")
    public String getBuy(){
        return "buy";

    }

}