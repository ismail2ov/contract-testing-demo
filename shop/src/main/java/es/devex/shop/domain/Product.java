package es.devex.shop.domain;

import lombok.Data;

@Data
public class Product {

    private Long id;

    private String name;

    private Price price;

    private Integer quantity;
}
