package dev.astrx.productserviceapp.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
@DiscriminatorValue(value = "2")
public class Students extends User {
    String course;
    String batch;
}
