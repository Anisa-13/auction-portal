package com.example.auction.controllers;

import com.example.auction.service.auction.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanNotificationInfo;
import java.util.UUID;

@Controller
public class DetailController {

    protected final AuctionService auctionService;

    public DetailController(final AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable String id, ModelMap model) {
       model.addAttribute("auction", auctionService.getAuctionById(id));
        return "itemDetail";
    }
}
