package com.example.auction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "bid")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private double amount;

    protected LocalDateTime bidAt;

    @Column(name = "user_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID userId;
    protected String userFullName;


    @Column(name = "auction_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID auctionId;
    protected String auctionName;
    protected String auctionDescription;
    protected String auctionImage;
    protected double auctionInitialPrice;
}
