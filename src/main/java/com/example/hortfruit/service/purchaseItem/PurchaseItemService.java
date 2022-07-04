package com.example.hortfruit.service.purchaseItem;

import com.example.hortfruit.model.purchaseItem.dto.PurchaseItemDTO;
import com.example.hortfruit.repository.purchaseItem.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseItemService {

    @Autowired
    private final PurchaseItemRepository purchaseItemRepository;


    public PurchaseItemService(PurchaseItemRepository purchaseItemRepository) {
        this.purchaseItemRepository = purchaseItemRepository;
    }

    public List<PurchaseItemDTO> findPurchaseItemByPurchaseId(Long purchaseId) {
        return purchaseItemRepository.findPurchaseItemByPurchaseId(purchaseId)
                .stream()
                .map(purchaseItem -> PurchaseItemDTO
                        .builder()
                        .productId(purchaseItem.getId())
                        .productName(purchaseItem.getProductName())
                        .quantity(purchaseItem.getQuantity())
                        .price(purchaseItem.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
