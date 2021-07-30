package com.example.auction.service.category;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Category;
import com.example.auction.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();


}
