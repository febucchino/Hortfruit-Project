package com.example.hortfruit.model.product.dto;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.supplier.Supplier;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String productName;
    private Double price;
    private Integer quantity;
    private Availability availability;
    private Supplier supplier;

    public Product convertToProduct() {
        return new Product(productName, price, quantity, availability, supplier);
    }
}
