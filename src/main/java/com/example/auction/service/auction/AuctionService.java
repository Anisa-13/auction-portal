package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuctionService {
    List<Auction> getCurrentAuctions();
    public Auction getAuctionById(String id);
    void createDummyData();
/*    Page<Auction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/
}
