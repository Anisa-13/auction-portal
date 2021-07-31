package com.example.auction.domain;

import com.example.auction.utils.AuctionStatus;
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
@Table(name = "auction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @NotEmpty
    private String image;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private double startPrice;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private boolean visible;
    protected UUID userId;
    protected String userDescription;
    protected double finalPrice;
    protected double sellPrice;
    @Enumerated(value = EnumType.STRING)
    protected AuctionStatus status;
    protected int bids = 0;

    protected String ownerId;
    protected String ownerFullName;
    protected String ownerDescription;


    @Column(name = "category_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;


}
