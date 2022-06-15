package com.example.hortfruit.model.supplier;

import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.supplier.dto.SupplierDTOResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Supplier {

    public Supplier(String companyName, String cnpj, String telephone, String email) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.telephone = telephone;
        this.email = email;
    }

    @Id
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_empresarial")
    private String companyName;

    private String cnpj;

    @Column(name = "telefone")
    private String telephone;

    private String email;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public SupplierDTOResponse toDTO(){
        return SupplierDTOResponse.builder()
                .id(getId())
                .companyName(getCompanyName())
                .cnpj(getCnpj())
                .telephone(getTelephone())
                .email(getEmail())
                .build();
    }
}
