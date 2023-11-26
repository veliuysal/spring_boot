package com.bilgeadam.springboot.services;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategorieesByDescriptionAndNativeQuery(String description) {
        return categoryRepository.findTurkishCategoriesInDescriptionByNativeQuery(description);
    }

    public Category saveCategory(Category category) {
        Integer idValue = categoryRepository.getMaxId() + 1;
        category.setId(idValue);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) throws Exception {
        if (Objects.isNull(category.getId())) {
            throw new Exception("ID boş bırakılamaz");
        }
        Optional<Category> optCategory = categoryRepository.findById(category.getId());
        if (optCategory.isEmpty()) {
            throw new Exception("ID alanı yanlış");
        }
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) throws Exception {
        categoryRepository.deleteById(id);
    }

}
