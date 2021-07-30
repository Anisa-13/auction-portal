package com.example.auction.controllers;

import com.example.auction.domain.Auction;
import com.example.auction.service.auction.AuctionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    protected final AuctionService auctionService;

    public HomeController(final AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
       // auctionService.createDummyData();
        model.addAttribute("currentAuctions", auctionService.getCurrentAuctions());
        return "index";
    }

  /*  @GetMapping("/")
    public String viewHomePage(ModelMap model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 8;

        Page<Auction> page = auctionService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Auction> currentAuctions = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("currentAuctions", currentAuctions);
        return "index";
    }*/

}
