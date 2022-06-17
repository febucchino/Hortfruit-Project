package com.example.hortfruit.model.product.dto;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.supplier.dto.SupplierDTOResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<SupplierDTOResponse> supplier;
}
