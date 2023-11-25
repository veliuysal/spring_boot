package com.bilgeadam.springboot.api;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.services.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoriesByNativeQuery(@RequestParam("description") String description) {
        return categoryService.getCategorieesByDescriptionAndNativeQuery(description);
    }

    @GetMapping(path = "/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoriesByNativeQueryInPath(@PathVariable("description") String description) {
        return categoryService.getCategorieesByDescriptionAndNativeQuery(description);
    }

}
