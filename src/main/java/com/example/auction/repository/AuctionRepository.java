package com.example.auction.repository;

import com.example.auction.domain.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AuctionRepository extends JpaRepository<Auction, UUID> {

    @Query(value = "select * from Auction o where o.status = 'ACTIVE'", nativeQuery = true)
    List<Auction> getActiveAuctions();

    /*@Query(value = "select * from Auction o where o.category_id = ?categoryId", nativeQuery = true)
    List<Auction> getAuctionsByCategory(String categoryId);*/


}
