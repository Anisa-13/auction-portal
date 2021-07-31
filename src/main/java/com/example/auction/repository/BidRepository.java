package com.example.auction.repository;

import com.example.auction.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {
    @Query(value = "select b from Bid b where b.auctionId = :id order by b.amount desc ")
    List<Bid> getBidsForAuction(@Param("id") UUID id);
}
