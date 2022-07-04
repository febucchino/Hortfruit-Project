package com.example.hortfruit.repository.purchaseItem;

import com.example.hortfruit.model.purchaseItem.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
    @Query(name = "select * from itens_pedido i, pedido p where p.id_pedido = 1 and p.id_pedido = i.id_pedido")
    List<PurchaseItem> findPurchaseItemByPurchaseId(Long id);
}
