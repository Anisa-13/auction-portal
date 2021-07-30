package com.example.auction.service.category;

import com.example.auction.domain.Category;
import com.example.auction.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    protected final CategoryRepository categoryRepository;

    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
       return this.categoryRepository.findAll();
    }

}
