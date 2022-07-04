package com.example.hortfruit.model.purchaseItem;

import com.example.hortfruit.model.purchase.Purchase;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itens_pedido")
public class PurchaseItem {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Purchase purchase;

    @Column(name = "nome_produto")
    private String productName;

    @Column(name = "quantidade")
    private int quantity;

    @Column(name = "preco_unitario")
    private Double price;
}
