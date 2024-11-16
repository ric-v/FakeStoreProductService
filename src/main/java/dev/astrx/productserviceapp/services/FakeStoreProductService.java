package dev.astrx.productserviceapp.services;

import dev.astrx.productserviceapp.dtos.FakeStoreDto;
import dev.astrx.productserviceapp.models.Category;
import dev.astrx.productserviceapp.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    // This service class interacts with the FakeStore API to fetch product details.
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreDto fakeStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreDto);
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
