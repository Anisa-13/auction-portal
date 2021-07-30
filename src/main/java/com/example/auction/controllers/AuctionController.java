package com.example.auction.controllers;

import com.example.auction.repository.AuctionRepository;
import com.example.auction.service.auction.AuctionService;
import com.example.auction.service.bid.BidService;
import com.example.auction.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class AuctionController {

    protected final CategoryService categoryService;
    protected final AuctionService auctionService;
    protected final BidService bidService;

    public AuctionController(final CategoryService categoryService, final AuctionService auctionService, final AuctionRepository auctionRepository, final BidService bidService){
        this.categoryService = categoryService;
        this.auctionService = auctionService;
        this.bidService = bidService;
    }

    @GetMapping("/auctions")
    public String getAuctions(ModelMap model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("recentBids", bidService);
        return "auction-list";
    }

    @GetMapping("/auction/{id}")
    public String getItem(@PathVariable String id, ModelMap model) {
        model.addAttribute("auction", auctionService.getAuctionById(id));
        return "auction-detail";
    }
}
