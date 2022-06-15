package com.example.hortfruit.model.supplier.dto;

import com.example.hortfruit.model.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    private String companyName;
    private String cnpj;
    private String telephone;
    private String email;

    public Supplier convertToSupplier(){
        return new Supplier(companyName, cnpj, telephone, email);
    }
}
