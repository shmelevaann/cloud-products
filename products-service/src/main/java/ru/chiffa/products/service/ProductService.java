package ru.chiffa.products.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chiffa.products.dto.ProductDto;
import ru.chiffa.products.dto.ProductsPageDto;
import ru.chiffa.products.model.Product;
import ru.chiffa.products.repository.ProductRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDto> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).map(Product::asDto);
    }

    public ProductDto save(ProductDto productDto) {
        Product product = new Product()
            .id(productDto.getId())
            .name(productDto.getName())
            .description(productDto.getDescription())
            .price(productDto.getPrice());

        return productRepository.save(product).asDto();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
