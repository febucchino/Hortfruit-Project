package com.example.hortfruit.model.product.dto;

import com.example.hortfruit.model.product.Availability;
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
}
