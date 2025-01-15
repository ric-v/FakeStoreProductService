package dev.astrx.productserviceapp.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a category of products.
 */
@Getter
@Setter
@Entity
public class Category extends BaseModel {
    String description;
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    // List<Product> productList;

}
