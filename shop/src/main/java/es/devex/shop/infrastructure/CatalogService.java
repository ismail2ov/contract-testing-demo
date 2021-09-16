package es.devex.shop.infrastructure;

import es.devex.shop.domain.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CatalogService {

    public static final String CATALOG_URL = "http://localhost:8080/products";

    private final RestTemplate restTemplate;

    public Products getProducts() {
        Products products = restTemplate.getForEntity(CATALOG_URL, Products.class).getBody();
        Objects.requireNonNull(products).getProducts().forEach(product -> product.setQuantity(1));

        return products;

    }
}
