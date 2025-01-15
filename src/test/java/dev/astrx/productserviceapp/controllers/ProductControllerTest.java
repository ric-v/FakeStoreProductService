package dev.astrx.productserviceapp.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import dev.astrx.productserviceapp.services.SelfProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.astrx.productserviceapp.exceptions.ProductNotCoveredException;
import dev.astrx.productserviceapp.models.Category;
import dev.astrx.productserviceapp.models.Product;
import dev.astrx.productserviceapp.projections.ProductTitleAndDescription;
import dev.astrx.productserviceapp.repos.CategoryRepo;
import dev.astrx.productserviceapp.repos.ProductRepo;

class SelfProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private SelfProductService selfProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() throws ProductNotCoveredException {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        ProductTitleAndDescription projection = mock(ProductTitleAndDescription.class);
        when(projection.getTitle()).thenReturn("Test Title");
        when(projection.getDescription()).thenReturn("Test Description");
        when(productRepo.getProductTitleAndDesc(productId)).thenReturn(projection);
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));

        Product result = selfProductService.getProductById(productId);

        assertNotNull(result);
        assertEquals(productId, result.getId());
        verify(productRepo).getProductTitleAndDesc(productId);
        verify(productRepo).findById(productId);
    }

    @Test
    void testGetProductByIdNotFound() {
        Long productId = 1L;
        when(productRepo.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ProductNotCoveredException.class, () -> selfProductService.getProductById(productId));
    }

    @Test
    void testCreateProductWithNewCategory() {
        Product product = new Product();
        Category category = new Category();
        product.setCategory(category);
        Category savedCategory = new Category();
        savedCategory.setId(1L);
        when(categoryRepo.save(category)).thenReturn(savedCategory);
        when(productRepo.save(product)).thenReturn(product);

        Product result = selfProductService.createProduct(product);

        assertNotNull(result);
        assertEquals(savedCategory.getId(), result.getCategory().getId());
        verify(categoryRepo).save(category);
        verify(productRepo).save(product);
    }

    @Test
    void testCreateProductWithExistingCategory() {
        Product product = new Product();
        Category category = new Category();
        category.setId(1L);
        product.setCategory(category);
        when(productRepo.save(product)).thenReturn(product);

        Product result = selfProductService.createProduct(product);

        assertNotNull(result);
        assertEquals(category.getId(), result.getCategory().getId());
        verify(productRepo).save(product);
    }
}