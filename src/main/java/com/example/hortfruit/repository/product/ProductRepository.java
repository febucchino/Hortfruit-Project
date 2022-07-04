package com.example.hortfruit.repository.product;

import com.example.hortfruit.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(name = "select * from produto p, fornecedor f where p.id_fornecedor = ?1 and p.id_fornecedor = f.id_fornecedor")
    List<Product> findProductsBySupplierId(Long id);
}
