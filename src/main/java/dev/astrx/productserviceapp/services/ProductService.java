package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.models.Product;

public interface ProductService {
    Product getProductById(Long id);
}
