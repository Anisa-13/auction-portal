package com.example.auction.service.bid;

import com.example.auction.domain.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getRecentBids();
}
