package dev.astrx.productserviceapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotCoveredExceptionDto {
    private Long errorCode;
    private String message;
}