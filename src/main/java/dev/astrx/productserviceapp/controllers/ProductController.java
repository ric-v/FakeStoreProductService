package dev.astrx.productserviceapp.controllers;

import dev.astrx.productserviceapp.models.Product;
import dev.astrx.productserviceapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling product-related API requests.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Updates a product by its ID.
     *
     * @param id      the ID of the product to update
     * @param product the updated product details
     * @return the updated product
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
