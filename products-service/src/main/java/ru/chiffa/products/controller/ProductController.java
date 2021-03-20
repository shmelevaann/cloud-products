package ru.chiffa.products.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.chiffa.products.dto.ProductDto;
import ru.chiffa.products.dto.ProductsPageDto;
import ru.chiffa.products.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ProductsPageDto list(Integer page, Integer size) {
        int realPage = page != null ? page : 0;
        int realSize = size != null ? size : 3;

        Page<ProductDto> productsPage = productService.findAll(realPage, realSize);

        return new ProductsPageDto(productsPage.getContent(), realPage, productsPage.getTotalPages());
    }

    @PutMapping("/")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product) {
        ProductDto saved = productService.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
