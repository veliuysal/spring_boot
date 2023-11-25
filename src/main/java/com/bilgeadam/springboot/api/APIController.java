package com.bilgeadam.springboot.api;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.services.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private final CategoryService categoryService;

    public APIController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @GetMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
}
