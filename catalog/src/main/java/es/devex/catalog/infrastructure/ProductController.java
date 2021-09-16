package es.devex.catalog.infrastructure;

import es.devex.catalog.domain.Product;
import es.devex.catalog.domain.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Products> getProducts() {

        var productsList = productService.getAll();
        var products = new Products(productsList);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Data
    private class Products {
        private final List<Product> products;

        public Products(List<Product> products) {
            this.products = products;
        }
    }
}
