package com.example.hortfruit.model.customer;

import com.example.hortfruit.model.customer.dto.CustomerDTOResponse;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Customer {

    public Customer(String name, String cpf, String telephone, String address) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.address = address;
    }

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telephone;

    @JoinColumn(name = "endereco")
    private String address;

    public CustomerDTOResponse toDTO(){
        return CustomerDTOResponse.builder()
                .id(getId())
                .name(getName())
                .cpf(getCpf())
                .telephone(getTelephone())
                .address(getAddress())
                .build();
    }
}
