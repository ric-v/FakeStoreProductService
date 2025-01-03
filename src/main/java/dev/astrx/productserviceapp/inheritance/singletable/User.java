package dev.astrx.productserviceapp.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "1")
public class User {
    @Id
    Long id;
    String name;
    String email;
    String password;
}
