package dev.astrx.productserviceapp.services;

import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.astrx.productserviceapp.exceptions.ProductNotCoveredException;
import dev.astrx.productserviceapp.models.Category;
import dev.astrx.productserviceapp.models.Product;
import dev.astrx.productserviceapp.projections.ProductTitleAndDescription;
import dev.astrx.productserviceapp.repos.CategoryRepo;
import dev.astrx.productserviceapp.repos.ProductRepo;

@Service("SelfProductService")
// @Primary
public class SelfProductService implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotCoveredException {
        System.out.println(id);

        ProductTitleAndDescription productTitleAndDescription = productRepo.getProductTitleAndDesc(id);
        System.out.println(
                "Projection: title - " + productTitleAndDescription.getTitle() + " description - "
                        + productTitleAndDescription.getDescription());
        // return productRepo.getProductTitleAndDesc(id);

        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotCoveredException(id, "Product not found withid: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category != null) {
            if (category.getId() == null) {
                Category savedCategory = categoryRepo.save(category);
                product.setCategory(savedCategory);
            }
            product.setCategory(category);
        }
        return productRepo.save(product);
    }
}
