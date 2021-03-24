package ru.chiffa.products.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

}
