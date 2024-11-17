package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.dtos.FakeStoreDto;
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

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    // This service class interacts with the FakeStore API to fetch product details.
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreDto fakeStoreDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id, FakeStoreDto.class
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreDto[] fakeStoreDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreDto[].class
        );
        List<Product> productList = new ArrayList<>();
        assert fakeStoreDtos != null;
        for (FakeStoreDto fakeStoreDto : fakeStoreDtos) {
            productList.add(convertFakeStoreProductDtoToProduct(fakeStoreDto));
        }
        return productList;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setTitle(product.getTitle());
        fakeStoreDto.setPrice(product.getPrice());
        fakeStoreDto.setDescription(product.getDescription());
        fakeStoreDto.setCategory(product.getCategory().getTitle());
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreDto, FakeStoreDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreDto.class);
        FakeStoreDto fakeStoreDto1 = Objects.requireNonNull(restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor)).getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreDto1);
    }

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
