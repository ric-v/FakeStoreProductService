package dev.astrx.productserviceapp.controllers;

import dev.astrx.productserviceapp.dtos.ProductNotCoveredExceptionDto;
import dev.astrx.productserviceapp.exceptions.ProductNotCoveredException;
import dev.astrx.productserviceapp.models.Product;
import dev.astrx.productserviceapp.services.ProductService;

import dev.astrx.productserviceapp.services.TokenService;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.management.InstanceNotFoundException;

/**
 * Controller class for handling product-related API requests.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    TokenService tokenService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService, TokenService tokenService) {
        this.productService = productService;
        this.tokenService = tokenService;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @RequestHeader("Token") String token,
            @PathVariable("id") Long id
    ) throws ProductNotCoveredException {

        if (!tokenService.validateToken(token)) {
            throw new UnknownAccessTypeException("Unauthorized access");
        }

        Product product;
        product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
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
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Handles ProductNotCoveredException and returns a response entity with a
     * NOT_FOUND status.
     *
     * @param e the ProductNotCoveredException thrown when an instance is not found
     * @return a ResponseEntity containing the exception message and a NOT_FOUND
     * status
     */
    @ExceptionHandler(ProductNotCoveredException.class)
    public ResponseEntity<ProductNotCoveredExceptionDto> handleInstanceNotFoundException(ProductNotCoveredException e) {
        ProductNotCoveredExceptionDto dto = new ProductNotCoveredExceptionDto();
        dto.setErrorCode(e.getId());
        dto.setMessage(e.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
