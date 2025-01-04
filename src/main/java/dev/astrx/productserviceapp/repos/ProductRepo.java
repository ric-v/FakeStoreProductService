package dev.astrx.productserviceapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.astrx.productserviceapp.models.Product;
import dev.astrx.productserviceapp.projections.ProductTitleAndDescription;

public interface ProductRepo extends JpaRepository<Product, Long> {

    // HQL
    @Query(value = "SELECT p.title as title, p.description as description FROM Product p WHERE p.id=:id")
    ProductTitleAndDescription getProductTitleAndDesc(@Param("id") Long id);

    // SQL
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductTitleAndDescription getProductTitleAndDescNative(@Param("id") Long id);
}
