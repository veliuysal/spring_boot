package com.bilgeadam.springboot.api;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void controllerTest() {
        String successReturn = "API is working";
        // Mockito.when(categoryController.isRunning()).thenReturn(successReturn);

        String response = categoryController.isRunning();
        Assertions.assertEquals(response, successReturn);
    }

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setDescription("Geliyor Gelmekte Olan");
        category.setName("Hallederiz");
        category.setId(11);

        Mockito.when(categoryController.saveCategory(category)).thenReturn(category);

        Category response = categoryController.saveCategory(category);
        Assertions.assertEquals(category.getDescription(), response.getDescription(), "Tanımlamalar yanlış");
        // Mockito.verify(categoryService, Mockito.times(1)).saveCategory(category);
    }

    @Test
    public void getAllCategories() {
        Category category = new Category();
        category.setDescription("Geliyor Gelmekte Olan");
        category.setName("Hallederiz");
        category.setId(11);

        List<Category> returnedList = new ArrayList<>();
        returnedList.add(category);

        Mockito.when(categoryController.getAllCategories()).thenReturn(returnedList);
        List<Category> categories = categoryController.getAllCategories();
        Assertions.assertEquals(1, categories.size(), "Kategoriler 1 tane gelmedi");
    }

}
