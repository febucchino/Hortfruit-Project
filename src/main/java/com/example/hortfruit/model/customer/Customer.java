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

    public Customer(String name, String cpf, String telephone) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
    }

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf ;

    @Column(name = "telefone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Address address;

    public CustomerDTOResponse toDTO(){
        return CustomerDTOResponse.builder()
                .id(getId())
                .name(getName())
                .cpf(getCpf())
                .telephone(getTelephone())
                .build();
    }
}
