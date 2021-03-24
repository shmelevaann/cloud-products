package ru.chiffa.products.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.chiffa.products.dto.ProductDto;

@Data
@Entity
@Accessors(fluent = true)
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDto asDto() {
        return ProductDto.builder().id(id).name(name).description(description).price(price).build();
    }
}
