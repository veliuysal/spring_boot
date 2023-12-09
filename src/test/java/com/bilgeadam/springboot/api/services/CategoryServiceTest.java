package com.bilgeadam.springboot.api.services;

import com.bilgeadam.springboot.repositories.CategoryRepository;
import com.bilgeadam.springboot.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void test() {

    }

}