package com.example.hortfruit.model.product.dto;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.product.Product;
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

    public Product convertToProduct() {
        return new Product(productName, price, quantity, availability);
    }
}
