package com.example.auction.service.auction;

import com.example.auction.domain.Auction;

import java.util.List;

public interface AuctionService {
    List<Auction> getCurrentAuctions();
    void createDummyData();
}
