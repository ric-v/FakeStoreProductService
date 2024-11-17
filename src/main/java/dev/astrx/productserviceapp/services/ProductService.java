package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.models.Product;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    Product getProductById(Long id);

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getAllProducts();

    /**
     * Updates a product by its ID.
     *
     * @param id the ID of the product to update
     * @param product the updated product details
     * @return the updated product
     */
    Product updateProduct(Long id, Product product);
}
