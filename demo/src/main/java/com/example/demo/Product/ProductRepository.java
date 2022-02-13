package com.example.demo.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%"
    + "OR p.productClass LIKE %?1%"
            + "OR p.details LIKE %?1%")
    public List<Product> findAll(String keyWord);

    @Query("SELECT p FROM Product p WHERE p.ID = ?1")
    public List<Product> findByID(int number);
}