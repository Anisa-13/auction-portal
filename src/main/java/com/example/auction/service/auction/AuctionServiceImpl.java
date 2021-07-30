package com.example.auction.service.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Category;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.CategoryRepository;
import com.example.auction.utils.AuctionStatus;
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
        List<Auction> auctionList = entityManager.createNativeQuery("SELECT * FROM Auction WHERE category_id = ?1;")
                .setParameter(1, "category")
                .getResultList();

        return auctionList;
    }

/*
    @Override
    public Page<Auction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.auctionRepository.findAll(pageable);
    }
*/

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
                .bids(10)
                .status(AuctionStatus.ACTIVE)
                .image("harry_potter.jpg")
                .build();

        auctionRepository.save(firstAuction);

        Auction secondAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("QUANTUM ELECTRODYNAMICS")
                .description("RICHARD P. FEYNMAN'S 1965 NOBEL PRIZE MEDAL IN PHYSICS FOR HIS FUNDAMENTAL WORK IN QUANTUM ELECTRODYNAMICS")
                .startPrice(2000)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(10)
                .status(AuctionStatus.ACTIVE)
                .image("richard_feynman.jpg")
                .build();

        auctionRepository.save(secondAuction);

        Auction thirdAuction = Auction.builder()
                .categoryId(firstCategory.getId())
                .name("The Whale")
                .description("MELVILLE, HERMAN | The Whale. London: Richard Bentley, 1851 ")
                .startPrice(5000)
                .startAt(LocalDateTime.now())
                .visible(true)
                .bids(10)
                .status(AuctionStatus.ACTIVE)
                .image("herman_melville.jpg")
                .build();

        auctionRepository.save(thirdAuction);
    }
}
