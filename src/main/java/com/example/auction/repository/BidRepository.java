package com.example.auction.repository;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {
}
