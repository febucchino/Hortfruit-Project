package com.example.hortfruit.model.customer;

import com.example.hortfruit.model.customer.dto.AddressDTO;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Address {

    @Id
    @Column(name = "id_endereco")
    private Long id;
    @Column(name = "rua")
    private String address;
    @Column(name = "numero")
    private String number;
    private String cep;
    @Column(name = "cidade")
    private String city;
    @Column(name = "estado")
    private String state;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public AddressDTO toDTO(){
        return AddressDTO.builder()
                .address(getAddress())
                .number(getNumber())
                .cep(getCep())
                .city(getCity())
                .state(getState())
                .build();
    }
}
