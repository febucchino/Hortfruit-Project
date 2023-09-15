package com.example.hortfruit.model.customer.dto;

import com.example.hortfruit.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String cpf ;
    private String telephone;
    private String address;

    public Customer convertToCustomer(){
        return new Customer(name, cpf, telephone, address);
    }
}
