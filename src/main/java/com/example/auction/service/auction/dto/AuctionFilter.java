package com.example.auction.service.auction.dto;

import com.example.auction.utils.AuctionStatus;
import lombok.Data;

@Data
public class AuctionFilter {
    protected String categoryId;
    protected String categoryName;
    protected AuctionStatus status;
}
