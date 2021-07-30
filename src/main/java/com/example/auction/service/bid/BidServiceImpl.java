package com.example.auction.service.bid;

import com.example.auction.domain.Bid;
import com.example.auction.repository.BidRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    protected final BidRepository bidRepository;

    public BidServiceImpl(final BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public List<Bid> getRecentBids() {
        return bidRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createdAt"))).getContent();
    }
}
