package com.example.hortfruit.model.purchase;

import com.example.hortfruit.model.customer.Address;
import com.example.hortfruit.model.customer.Customer;
import com.example.hortfruit.model.purchaseItem.PurchaseItem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Purchase {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItem> purchaseItens;

    @Column(name = "numero_pedido")
    private int purchaseNumber;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Address address;

    @Column(name = "data_pedido", columnDefinition = "TIMESTAMP")
    private LocalDate purchaseDate;
}
