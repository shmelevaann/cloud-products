package ru.chiffa.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chiffa.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
