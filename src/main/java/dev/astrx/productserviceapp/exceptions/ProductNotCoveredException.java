package dev.astrx.productserviceapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotCoveredException extends Exception {
    private Long id;

    public ProductNotCoveredException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
