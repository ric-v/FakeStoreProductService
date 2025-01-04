package dev.astrx.productserviceapp.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
    @OneToMany(fetch = FetchType.EAGER)
    List<Product> productList;
}
