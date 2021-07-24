package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {
    @GetMapping("/detail")
    public String getItem() {
        return "itemDetail";
    }
}