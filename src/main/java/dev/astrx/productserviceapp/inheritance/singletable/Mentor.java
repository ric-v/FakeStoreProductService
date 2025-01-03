package dev.astrx.productserviceapp.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue(value = "3")
public class Mentor extends User {
    String company;
    int avgRating;
}
