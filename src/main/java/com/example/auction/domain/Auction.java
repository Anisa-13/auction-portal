package com.example.auction.domain;

import com.example.auction.utils.AuctionStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auction")
@Data
public class Auction {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotEmpty
    private String image;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private double startPrice;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private boolean visible;
    protected UUID userId;
    protected String userDescription;
    protected double finalPrice;
    @Enumerated(value = EnumType.STRING)
    protected AuctionStatus status;

    @Column(name = "category_id")
    protected UUID categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;


}
