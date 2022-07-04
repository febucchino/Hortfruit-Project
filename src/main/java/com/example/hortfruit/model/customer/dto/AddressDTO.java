package com.example.hortfruit.model.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String address;
    private String number;
    private String cep;
    private String city;
    private String state;
}
