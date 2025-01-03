package dev.astrx.productserviceapp.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
public class Students extends User {
    String course;
    String batch;
}
