package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import com.example.auction.service.auction.dto.AuctionFilter;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public interface AuctionService {
    List<Auction> getCurrentAuctions();
    Auction getAuctionById(String id);
    List<Auction> getAuctionsByCategory(String category);
    List<Auction> getList(AuctionFilter filter);
    void createDummyData();
}
