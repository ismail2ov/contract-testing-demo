package es.devex.shop.domain;

import lombok.Data;

@Data
public class Product {

    private Long productId;

    private String productName;

    private String price;

    private Integer quantity;
}
