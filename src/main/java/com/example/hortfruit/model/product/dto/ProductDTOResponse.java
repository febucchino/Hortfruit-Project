package com.example.hortfruit.model.product.dto;

import com.example.hortfruit.model.product.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {

    private Long id;
    private String productName;
    private Double price;
    private Integer quantity;
    private Availability availability;
}
