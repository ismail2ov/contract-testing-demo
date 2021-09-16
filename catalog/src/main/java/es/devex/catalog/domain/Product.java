package es.devex.catalog.domain;

import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    @Convert(converter = PriceConverter.class)
    private Price price;
}
