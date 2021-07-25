package com.example.auction.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Auction> auctions = new ArrayList<>();



}
