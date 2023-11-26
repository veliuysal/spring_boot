package com.bilgeadam.springboot.repositories;

import com.bilgeadam.springboot.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByName(String name);

    @Query("SELECT c FROM Category c WHERE c.description LIKE %:descr%")
    List<Category> findTurkishCategoriesInDescription(@Param("descr") String description);

    @Query(value = "SELECT c.* FROM Categories c WHERE c.description LIKE %:description%", nativeQuery = true)
    List<Category> findTurkishCategoriesInDescriptionByNativeQuery(@Param("description") String description);

    @Query(value = "SELECT MAX(c.id) FROM Category c")
    Integer getMaxId();

    Optional<Category> findById(Integer id);
}
