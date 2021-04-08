package com.accenture.orderservice.repository;

import com.accenture.orderservice.domains.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findByBrand(String brand);
}
