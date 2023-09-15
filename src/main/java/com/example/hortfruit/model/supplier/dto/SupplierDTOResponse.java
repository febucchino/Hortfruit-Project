package com.example.hortfruit.model.supplier.dto;

import com.example.hortfruit.model.supplier.Supplier;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTOResponse {

    private Long id;
    private String companyName;
    private String cnpj;
    private String telephone;
    private String email;

    public Supplier convertToSupplier() {
        return new Supplier(id, companyName, cnpj, telephone, email);
    }
}
