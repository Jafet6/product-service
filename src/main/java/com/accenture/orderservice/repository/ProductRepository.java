package com.accenture.orderservice.repository;

import com.accenture.orderservice.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long id);
    List<Product> findAllByBrandId(Long id);
}
