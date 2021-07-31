package com.example.auction.service.bid;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Bid;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.BidRepository;
import com.example.auction.service.auction.dto.BidRequest;
import com.example.auction.utils.AuctionStatus;
import com.example.auction.utils.ServiceResult;
import com.github.javafaker.Faker;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BidServiceImpl implements BidService {
    protected final BidRepository bidRepository;
    protected final AuctionRepository auctionRepository;

    public BidServiceImpl(final BidRepository bidRepository, final AuctionRepository auctionRepository) {
        this.bidRepository = bidRepository;
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Bid> getRecentBids() {
        return bidRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "bidAt"))).getContent();
    }

    @Override
    public List<Bid> getRecentBids(String id) {
        return bidRepository.getBidsForAuction(UUID.fromString(id));
    }

    @Override
    public ServiceResult saveBid(BidRequest request) {
        Auction auction = auctionRepository.getById(UUID.fromString(request.getId()));
        if (auction == null)
            return ServiceResult.Error("Auction not found in database");

        if (auction.getStartPrice() > request.getAmount())
            return ServiceResult.Error("Mininum amount not offered on bid!");

        if (!AuctionStatus.ACTIVE.equals(auction.getStatus()))
            return ServiceResult.Error("Auction not available for biding!");

        Faker faker = new Faker();
        String name = faker.name().fullName();

        Bid bid = Bid.builder()
                .amount(request.getAmount())
                .auctionId(auction.getId())
                .auctionDescription(auction.getDescription())
                .auctionImage(auction.getImage())
                .auctionInitialPrice(auction.getStartPrice())
                .auctionName(auction.getName())
                .bidAt(LocalDateTime.now())
                .userId(UUID.randomUUID())
                .userFullName(name)
                .amount(request.getAmount())
                .build();
        bidRepository.save(bid);

        auction.setBids(auction.getBids() + 1);
        auctionRepository.save(auction);

        return ServiceResult.Success();
    }

    @Override
    public ServiceResult sellAuction(BidRequest request) {
        Auction auction = auctionRepository.getById(UUID.fromString(request.getId()));
        if (auction == null)
            return ServiceResult.Error("Auction not found in database");

        if (!AuctionStatus.ACTIVE.equals(auction.getStatus()))
            return ServiceResult.Error("Auction not available for selling!");

        Faker faker = new Faker();
        String name = faker.name().fullName();
        UUID userId = UUID.randomUUID();

        auction.setFinalPrice(auction.getSellPrice());
        auction.setUserId(userId);
        auction.setUserDescription(name);
        auction.setStatus(AuctionStatus.SOLD);
        auctionRepository.save(auction);

        return ServiceResult.Success();
    }
}
