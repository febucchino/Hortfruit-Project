package com.example.hortfruit.model.supplier.dto;

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
    private String cnpj ;
    private String telephone;
    private String email;
}
