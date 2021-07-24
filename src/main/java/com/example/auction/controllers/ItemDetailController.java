package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemDetailController {
    @GetMapping("/item")
    public String getItem() {
        return "itemDetail";
    }

}