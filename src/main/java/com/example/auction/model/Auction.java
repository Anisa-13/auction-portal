package com.example.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auctionId;

    @NotEmpty
    private String auctionPhoto;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String description;

    @NotEmpty
    private Integer startPrice;

    private Date startDate;

    private Date endDate;

    private boolean isConfirmed;

    @OneToMany(mappedBy = "bid")
    private List<Bid> bids = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "auctions")
    private Category category;

    public Auction() {
    }

    public Auction(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionPhoto() {
        return auctionPhoto;
    }

    public void setAuctionPhoto(String auctionPhoto) {
        this.auctionPhoto = auctionPhoto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
