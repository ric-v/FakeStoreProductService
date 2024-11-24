package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.exceptions.ProductNotCoveredException;
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
     * @throws ProductNotCoveredException
     */
    Product getProductById(Long id) throws ProductNotCoveredException;

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getAllProducts();

    /**
     * Updates a product by its ID.
     *
     * @param id      the ID of the product to update
     * @param product the updated product details
     * @return the updated productw
     */
    Product updateProduct(Long id, Product product);
}
