package dev.astrx.productserviceapp.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product with its details.
 */
@Getter
@Setter
public class Product {
    Long id;
    String title;
    String description;
    Double price;
    Category category;
}
