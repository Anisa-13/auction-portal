package com.example.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;

    @NotEmpty
    private Integer bidPrice;

    @ManyToOne
    @JoinColumn(name = "bids")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bids")
    private Auction auction;

    public Bid() {
    }

    public Bid(Integer bidId, Integer bidPrice) {
        this.bidId = bidId;
        this.bidPrice = bidPrice;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
