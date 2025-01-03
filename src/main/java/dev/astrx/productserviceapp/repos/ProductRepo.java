package dev.astrx.productserviceapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.astrx.productserviceapp.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
