package com.example.hortfruit.model.product;

import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import com.example.hortfruit.model.supplier.Supplier;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Product {

    public Product(String productName, Double price, Integer quantity, Availability availability) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.availability = availability;
    }

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_produto")
    private String productName;

    @Column(name = "preco")
    private Double price;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "disponibilidade")
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Supplier supplier;

    public ProductDTOResponse toDTO(){
        return ProductDTOResponse.builder()
                .id(getId())
                .productName(getProductName())
                .price(getPrice())
                .quantity(getQuantity())
                .availability(getAvailability())
                .supplier(supplier)
                .build();
    }
}
