package com.example.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
  @GetMapping("/contact")
  public String contact(ModelMap model) {
    model.addAttribute("page", "contact");
    return "contact";
  }
}
