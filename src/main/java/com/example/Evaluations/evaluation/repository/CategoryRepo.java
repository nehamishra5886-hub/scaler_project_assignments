package com.example.Evaluations.evaluation.repository;

import com.example.Evaluations.evaluation.model.Category;
import com.example.Evaluations.evaluation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    // Get products by name
    List<Product> findByName(String name);

    // Delete product by ID
    void deleteById(Long id);

    // Delete all products
    void deleteAll();

    // Delete products by name and return count
    Long deleteByName(String name);

    // Delete products by category name
    Long deleteByCategoryName(String categoryName);

    // Delete product where product ID matches category ID
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = :categoryId")
    void deleteProductWhereIdMatchesCategoryId(
            @Param("categoryId") Long categoryId);

    // Retain products created after the given date
    @Modifying
    @Query("DELETE FROM Product p WHERE p.createdAt <= :retainDate")
    int retainProductsAfter(@Param("retainDate") Date retainDate);

}