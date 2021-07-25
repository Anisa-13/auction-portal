package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import com.example.auction.repository.AuctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    protected  final AuctionRepository auctionRepository;

    public AuctionServiceImpl(final AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> getCurrentAuctions() {
        return auctionRepository.findAll();
    }
}
