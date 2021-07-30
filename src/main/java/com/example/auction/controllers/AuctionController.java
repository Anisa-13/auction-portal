package com.example.auction.controllers;

import com.example.auction.repository.AuctionRepository;
import com.example.auction.service.auction.AuctionService;
import com.example.auction.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class AuctionController {

    protected final CategoryService categoryService;
    protected final AuctionService auctionService;

    public AuctionController(final CategoryService categoryService, final AuctionService auctionService, final AuctionRepository auctionRepository){
        this.categoryService = categoryService;
        this.auctionService = auctionService;
    }

    @GetMapping("/auction")
    public String getBuy(ModelMap model){
       // model.addAttribute("currentAuctions", auctionService.getAuctionsByCategory(categoryService.getCategories().get(1).getId()));

        model.addAttribute("categories", categoryService.getCategories());
        return "auctions";
    }

}
