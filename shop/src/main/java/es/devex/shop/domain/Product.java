package es.devex.shop.domain;

import lombok.Data;

@Data
public class Product {

    private Long id;

    private String name;

    private String price;

    private Integer quantity;
}
