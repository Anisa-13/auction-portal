package com.example.auction.service.bid;

import com.example.auction.domain.Bid;
import com.example.auction.service.auction.dto.BidRequest;
import com.example.auction.utils.ServiceResult;

import java.util.List;

public interface BidService {
    List<Bid> getRecentBids();
    List<Bid> getRecentBids(String id);
    ServiceResult saveBid(BidRequest request);
    ServiceResult sellAuction(BidRequest request);
}
