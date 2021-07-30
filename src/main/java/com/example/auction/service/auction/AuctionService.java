package com.example.auction.service.auction;

import com.example.auction.domain.Auction;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public interface AuctionService {
    List<Auction> getCurrentAuctions();
    public Auction getAuctionById(String id);
    List<Auction> getAuctionsByCategory(String category);
    void createDummyData();
/*    Page<Auction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/

}
