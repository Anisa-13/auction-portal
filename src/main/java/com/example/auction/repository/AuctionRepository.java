package com.example.auction.repository;

import com.example.auction.domain.Auction;
import com.example.auction.utils.AuctionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AuctionRepository extends JpaRepository<Auction, UUID> {

    @Query(value = "select * from Auction o where o.status = 'ACTIVE' order by o.start_at desc limit 6", nativeQuery = true)
    List<Auction> getActiveAuctions();

    @Query(value = "select p from Auction p where (:categoryId is null or cast(p.categoryId as string) = :categoryId) " +
            "and (:status is null or p.status = :status) " +
            "order by p.startAt desc "
    )
    List<Auction> getList(
            @Param("categoryId") String categoryId,
            @Param("status") AuctionStatus status
    );

}
