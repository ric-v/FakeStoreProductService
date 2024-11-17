package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);
}
