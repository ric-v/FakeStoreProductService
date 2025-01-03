package dev.astrx.productserviceapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.astrx.productserviceapp.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}