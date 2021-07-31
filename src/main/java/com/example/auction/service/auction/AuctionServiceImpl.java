package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Category;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.CategoryRepository;
import com.example.auction.service.auction.dto.AuctionFilter;
import com.example.auction.utils.AuctionStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    EntityManager entityManager;

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
    public Auction getAuctionById(String id) {
        try {
            return auctionRepository.getById(UUID.fromString(id));
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Auction> getAuctionsByCategory(String category) {
        return entityManager.createNativeQuery("SELECT * FROM Auction WHERE category_id = ?1;")
                .setParameter(1, "category")
                .getResultList();
    }

    @Override
    public List<Auction> getList(AuctionFilter filter) {
        if (filter != null && filter.getCategoryId() != null && !filter.getCategoryId().isEmpty()) {
            Category category = categoryRepository.getById(UUID.fromString(filter.getCategoryId()));
            if (category != null)
                filter.setCategoryName(category.getName());
        }

        return auctionRepository.getList(
                StringUtils.isNotBlank(filter.getCategoryId()) ? filter.getCategoryId() : null,
                filter.getStatus()
        );
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

        Category thirdCategory = Category.builder()
                .name("Decor")
                .build();
        categoryRepository.save(thirdCategory);

        Category forthCategory = Category.builder()
                .name("Clock")
                .build();
        categoryRepository.save(forthCategory);

        Category fifthCategory = Category.builder()
                .name("Sculpture")
                .build();
        categoryRepository.save(fifthCategory);

        Auction firstAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("Harry Potter and the Philosopher's Stone.")
                .description("ROWLING, J.K. | Harry Potter and the Philosopher's Stone. London: Bloomsbury, 1999")
                .startPrice(200)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(0)
                .sellPrice(800)
                .status(AuctionStatus.ACTIVE)
                .image("harry_potter.jpg")
                .ownerId(UUID.randomUUID().toString())
                .ownerFullName("Collen Winston")
                .ownerDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil repudiandae recusandae, incidunt possimus provident vel facilis!")
                .build();

        auctionRepository.save(firstAuction);

        Auction secondAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("QUANTUM ELECTRODYNAMICS")
                .description("RICHARD P. FEYNMAN'S 1965 NOBEL PRIZE MEDAL IN PHYSICS FOR HIS FUNDAMENTAL WORK IN QUANTUM ELECTRODYNAMICS")
                .startPrice(2000)
                .startAt(LocalDateTime.now())
                .visible(true)
                .sellPrice(4000)
                .bids(0)
                .status(AuctionStatus.ACTIVE)
                .ownerId(UUID.randomUUID().toString())
                .ownerFullName("John Smith")
                .ownerDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil repudiandae recusandae, incidunt possimus provident vel facilis!")
                .image("richard_feynman.jpg")
                .build();

        auctionRepository.save(secondAuction);

        Auction thirdAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("The Whale")
                .description("MELVILLE, HERMAN | The Whale. London: Richard Bentley, 1851 ")
                .startPrice(5000)
                .sellPrice(9000)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(0)
                .status(AuctionStatus.ACTIVE)
                .image("herman_melville.jpg")
                .ownerId(UUID.randomUUID().toString())
                .ownerFullName("Gerard Harold")
                .ownerDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil repudiandae recusandae, incidunt possimus provident vel facilis!")
                .build();

        auctionRepository.save(thirdAuction);
    }
}
