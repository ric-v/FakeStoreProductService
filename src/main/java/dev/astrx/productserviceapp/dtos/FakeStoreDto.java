package dev.astrx.productserviceapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    Long id;
    String title;
    Double price;
    String category;
    String description;
}
