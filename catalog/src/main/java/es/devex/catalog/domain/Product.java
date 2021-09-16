package es.devex.catalog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private Long productId;

    private String productName;

    private String price;
}
