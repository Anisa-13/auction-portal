package com.example.auction.controllers;

import com.example.auction.domain.Auction;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.service.auction.AuctionService;
import com.example.auction.service.auction.dto.AuctionFilter;
import com.example.auction.service.auction.dto.BidRequest;
import com.example.auction.service.bid.BidService;
import com.example.auction.service.category.CategoryService;
import com.example.auction.utils.ServiceResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/auctions/filter-category/{id}")
    public String filterByCategory(@PathVariable String id, ModelMap model) {
        AuctionFilter filter = new AuctionFilter();
        filter.setCategoryId(id);

        model.addAttribute("auctions", auctionService.getList(filter));
        model.addAttribute("filter", filter);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("bids", bidService.getRecentBids());
        model.addAttribute("page", "auction");
        return "auction-list";
    }

    @GetMapping("/auctions")
    public String getAuctions(ModelMap model) {
        model.addAttribute("auctions", auctionService.getList(new AuctionFilter()));
        model.addAttribute("filter", new AuctionFilter());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("bids", bidService.getRecentBids());
        model.addAttribute("page", "auction");
        return "auction-list";
    }

    @PostMapping("/auction/bid/{id}")
    public String bid(@Valid @ModelAttribute BidRequest bid, BindingResult result, @PathVariable String id, ModelMap model) {
        if (!result.hasErrors()) {
            ServiceResult bidResult = bidService.saveBid(bid);
            if (bidResult.isSuccess())
                return "redirect:/auction/bid/success/" + id;

            model.addAttribute("bidError", bidResult.getMessage());
        }

        model.addAttribute("bid", bid);
        model.addAttribute("auction", auctionService.getAuctionById(id));
        model.addAttribute("bids", bidService.getRecentBids(id));
        model.addAttribute("sell", new BidRequest());

        model.addAttribute("page", "auction");
        return "auction-detail";
    }

    @PostMapping("/auction/sell/{id}")
    public String sell(@Valid @ModelAttribute BidRequest bid, BindingResult result, @PathVariable String id, ModelMap model) {
        if (!result.hasErrors()) {
            ServiceResult sellResult = bidService.sellAuction(bid);
            if (sellResult.isSuccess())
                return "redirect:/auction/sell/success/" + id;

            model.addAttribute("sellError", sellResult.getMessage());
        }

        model.addAttribute("auction", auctionService.getAuctionById(id));
        model.addAttribute("bids", bidService.getRecentBids(id));
        model.addAttribute("bid", new BidRequest());
        model.addAttribute("sell", bid);

        model.addAttribute("page", "auction");
        return "auction-detail";
    }

    @GetMapping("/auction/{id}")
    public String getDetail(@PathVariable String id, ModelMap model) {
        initAuctionDetailModelMap(model, id);
        return "auction-detail";
    }

    @GetMapping("/auction/bid/success/{id}")
    public String bidSuccess(@PathVariable String id, ModelMap model) {
        initAuctionDetailModelMap(model, id);
        model.addAttribute("bidSuccess", "Bid placed successfully!");
        return "auction-detail";
    }

    @GetMapping("/auction/sell/success/{id}")
    public String sellSuccess(@PathVariable String id, ModelMap model) {
        initAuctionDetailModelMap(model, id);
        model.addAttribute("sellSuccess", "Sell was saved successfully!");
        return "auction-detail";
    }

    private void initAuctionDetailModelMap (ModelMap model, String id) {
        Auction auction = auctionService.getAuctionById(id);
        model.addAttribute("auction", auction);
        BidRequest bid = new BidRequest();
        bid.setAmount(auction.getStartPrice() + 1);
        model.addAttribute("bid", bid);
        model.addAttribute("bids", bidService.getRecentBids(id));
        model.addAttribute("sell", new BidRequest());
        model.addAttribute("page", "auction");
    }
}

