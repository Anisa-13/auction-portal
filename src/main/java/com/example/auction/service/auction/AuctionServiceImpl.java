package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Category;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.CategoryRepository;
import com.example.auction.utils.AuctionStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    protected final AuctionRepository auctionRepository;
    protected final CategoryRepository categoryRepository;

    public AuctionServiceImpl(final AuctionRepository auctionRepository, final CategoryRepository categoryRepository) {
        this.auctionRepository = auctionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Auction> getCurrentAuctions() {
        return auctionRepository.getActiveAuctions();
    }

    @Override
    public void createDummyData() {
        Category firstCategory = Category.builder()
                .name("Book")
                .build();
        categoryRepository.save(firstCategory);

        Category secondCategory = Category.builder()
                .name("Painting")
                .build();
        categoryRepository.save(secondCategory);

        Auction firstAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("Marvel book")
                .description("Marvel book description")
                .startPrice(200)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(10)
                .status(AuctionStatus.ACTIVE)
                .image("marvel_book.jpg")
                .build();

        auctionRepository.save(firstAuction);

        Auction secondAuction = Auction.builder()
                .categoryId(secondCategory.getId())
                .name("Picasso")
                .description("The picasso description")
                .startPrice(200)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(10)
                .status(AuctionStatus.ACTIVE)
                .image("picaso.jpg")
                .build();

        auctionRepository.save(secondAuction);
    }
}
