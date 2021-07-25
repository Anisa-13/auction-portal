package com.example.auction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "auction")
@Data
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private int id;

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

    @OneToMany(mappedBy = "auction")
    private List<Bid> bids = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;


}
