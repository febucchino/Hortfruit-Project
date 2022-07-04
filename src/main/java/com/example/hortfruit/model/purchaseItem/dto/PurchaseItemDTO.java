package com.example.hortfruit.model.purchaseItem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDTO {

    private Long productId;
    private String productName;
    private int quantity;
    private Double price;
}
