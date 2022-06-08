package com.example.hortfruit.model.customer.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTOResponse {

    private Long id;
    private String name;
    private String cpf ;
    private String telephone;
}
