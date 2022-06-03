package com.example.hortfruit.repository.product;

import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
