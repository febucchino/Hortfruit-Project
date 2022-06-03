package com.example.hortfruit.repository.product;

import com.example.hortfruit.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductStrategyRepository {

    List<Product> findProduto(Optional<String> nome,
                              Optional<Long> id);
}
