package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.dtos.FakeStoreDto;
import dev.astrx.productserviceapp.exceptions.ProductNotCoveredException;
import dev.astrx.productserviceapp.models.Category;
import dev.astrx.productserviceapp.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.management.InstanceNotFoundException;

/**
 * Service class for interacting with the FakeStore API to fetch and update
 * product details.
 */
@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    /**
     * Constructs a new FakeStoreProductService with the given RestTemplate.
     *
     * @param restTemplate the RestTemplate to use for API requests
     */
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product createProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Retrieves a product by its ID from the FakeStore API.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     * @throws ProductNotCoveredException
     */
    @Override
    public Product getProductById(Long id) throws ProductNotCoveredException {
        FakeStoreDto fakeStoreDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id, FakeStoreDto.class);
        if (fakeStoreDto == null) {
            throw new ProductNotCoveredException(100L, "Product with ID " + id + " not found");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreDto);
    }

    /**
     * Retrieves all products from the FakeStore API.
     *
     * @return a list of all products
     */
    @SuppressWarnings("null")
    @Override
    public List<Product> getAllProducts() {
        FakeStoreDto[] fakeStoreDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreDto[].class);
        List<Product> productList = new ArrayList<>();
        assert fakeStoreDtos != null;
        for (FakeStoreDto fakeStoreDto : fakeStoreDtos) {
            productList.add(convertFakeStoreProductDtoToProduct(fakeStoreDto));
        }
        return productList;
    }

    /**
     * Updates a product by its ID in the FakeStore API.
     *
     * @param id      the ID of the product to update
     * @param product the updated product details
     * @return the updated product
     */
    @Override
    public Product updateProduct(Long id, Product product) {

        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setTitle(product.getTitle());
        fakeStoreDto.setPrice(product.getPrice());
        fakeStoreDto.setDescription(product.getDescription());
        fakeStoreDto.setCategory(product.getCategory().getTitle());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreDto, FakeStoreDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor = restTemplate
                .responseEntityExtractor(FakeStoreDto.class);

        FakeStoreDto fakeStoreDto1 = Objects.requireNonNull(restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor)).getBody();

        return convertFakeStoreProductDtoToProduct(fakeStoreDto1);
    }

    /**
     * Converts a FakeStoreDto to a Product.
     *
     * @param fakeStoreDto the FakeStoreDto to convert
     * @return the converted Product
     */
    private Product convertFakeStoreProductDtoToProduct(FakeStoreDto fakeStoreDto) {
        if (fakeStoreDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreDto.getId());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setDescription(fakeStoreDto.getDescription());

        Category category = new Category();
        category.setId((long) (Math.random() * 1000));
        category.setTitle(fakeStoreDto.getCategory());
        product.setCategory(category);

        return product;
    }

}
