package com.example.hortfruit.repository.purchase;

import com.example.hortfruit.model.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByPurchaseNumber(int purchaseNumber);

    List<Purchase> findByCustomerId(Long customerId);
}
