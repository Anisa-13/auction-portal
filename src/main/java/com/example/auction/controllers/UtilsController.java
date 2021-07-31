package com.example.auction.controllers;

import com.example.auction.service.auction.AuctionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsController {
    final AuctionService auctionService;

    public UtilsController(final AuctionService service) {
        this.auctionService = service;
    }

    @ResponseBody
    @RequestMapping(value = "/utils/create-initial-data")
    public ResponseEntity<String> createInitialData() {
        auctionService.createDummyData();
        return ResponseEntity.ok("Data created successfully!");
    }
}
