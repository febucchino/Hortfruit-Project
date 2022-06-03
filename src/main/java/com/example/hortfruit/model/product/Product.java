package com.example.hortfruit.model.product;

import com.example.hortfruit.model.product.dto.ProductDTOResponse;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Product {

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

    public ProductDTOResponse toDTO(){
        return ProductDTOResponse.builder()
                .id(getId())
                .productName(getProductName())
                .price(getPrice())
                .quantity(getQuantity())
                .availability(getAvailability())
                .build();
    }

    // private Fornecedor fornecedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
