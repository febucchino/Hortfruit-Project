package com.example.hortfruit.model.purchase.dto;

import com.example.hortfruit.model.customer.dto.AddressDTO;
import com.example.hortfruit.model.customer.dto.CustomerDTOResponse;
import com.example.hortfruit.model.purchaseItem.dto.PurchaseItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTOResponse {

    private int purchaseNumber;
    private List<PurchaseItemDTO> productList;
    private CustomerDTOResponse customer;
    private AddressDTO address;
    private String purchaseDate;

}
