package dev.astrx.productserviceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product with its details.
 */
@Getter
@Setter
@Entity
public class Product extends BaseModel {
    String description;
    Double price;
    @ManyToOne
    Category category;
}
