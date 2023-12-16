package com.bilgeadam.springboot.services;

import com.bilgeadam.springboot.models.Category;
import com.bilgeadam.springboot.repositories.CategoryRepository;
import com.bilgeadam.springboot.services.CategoryService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Before
    public void setup(){
        Category emptyID=new Category();
        emptyID.setId(12);
        emptyID.setName("Boş");

        Mockito.when(categoryRepository.findById(12)).thenReturn(Optional.of(emptyID));
    }

    @Test
    public void updateCategory() {

    }

}