package com.bilgeadam.springboot.services;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
