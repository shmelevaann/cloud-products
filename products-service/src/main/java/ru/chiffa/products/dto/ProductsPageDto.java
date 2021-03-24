package ru.chiffa.products.dto;

import java.util.List;
import lombok.Data;

@Data
public class ProductsPageDto {

    private final List<ProductDto> products;
    private final int currentPage;
    private final int totalPages;

}
