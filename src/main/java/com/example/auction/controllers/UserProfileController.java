package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
    @GetMapping("/profile")
    public String getLogin(){
        return "userProfile";
    }

}
