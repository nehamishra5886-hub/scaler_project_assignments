package com.example.Evaluations.evaluation.repository;

import com.example.Evaluations.evaluation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    // To do: Add methods to handle product deletion operations
}
