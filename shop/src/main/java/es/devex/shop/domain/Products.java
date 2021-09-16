package es.devex.shop.domain;

import lombok.Data;

import java.util.List;

@Data
public class Products {
    private List<Product> products;
}