package dev.astrx.productserviceapp.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for representing product information from the
 * FakeStore API.
 */
@Getter
@Setter
public class FakeStoreDto {
    Long id;
    String title;
    Double price;
    String category;
    String description;
}
