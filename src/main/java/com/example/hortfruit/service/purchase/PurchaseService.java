package com.example.hortfruit.service.purchase;

import com.example.hortfruit.model.purchase.dto.PurchaseDTOResponse;
import com.example.hortfruit.repository.purchase.PurchaseRepository;
import com.example.hortfruit.service.customer.CustomerService;
import com.example.hortfruit.service.purchaseItem.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private final PurchaseRepository purchaseRepository;

    @Autowired
    private final PurchaseItemService purchaseItemService;

    @Autowired
    private final CustomerService customerService;

    public PurchaseService(PurchaseRepository purchaseRepository, PurchaseItemService purchaseItemService, CustomerService customerService) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseItemService = purchaseItemService;
        this.customerService = customerService;
    }

    public List<PurchaseDTOResponse> findAllPurchase() {

        return purchaseRepository.findAll()
                .stream()
                .map(purchase -> PurchaseDTOResponse
                        .builder()
                        .purchaseNumber(purchase.getPurchaseNumber())
                        .productList(purchaseItemService.findPurchaseItemByPurchaseId(purchase.getId()))
                        .customer(customerService.findCustomerById(purchase.getCustomer().getId()).get(0))
                        .purchaseDate(purchase.getPurchaseDate().toString())
                        .build())
                .collect(Collectors.toList());
    }

    public List<PurchaseDTOResponse> findPurchaseByPurchaseNumber(int purchaseNumber) {

        return purchaseRepository.findByPurchaseNumber(purchaseNumber)
                .stream()
                .map(purchase -> PurchaseDTOResponse
                        .builder()
                        .purchaseNumber(purchase.getPurchaseNumber())
                        .productList(purchaseItemService.findPurchaseItemByPurchaseId(purchase.getId()))
                        .customer(customerService.findCustomerById(purchase.getCustomer().getId()).get(0))
                        .purchaseDate(purchase.getPurchaseDate().toString())
                        .build())
                .collect(Collectors.toList());
    }

    public List<PurchaseDTOResponse> findPurchaseByCustomerId(Long customerId) {

        return purchaseRepository.findByCustomerId(customerId)
                .stream()
                .map(purchase -> PurchaseDTOResponse
                        .builder()
                        .purchaseNumber(purchase.getPurchaseNumber())
                        .productList(purchaseItemService.findPurchaseItemByPurchaseId(purchase.getId()))
                        .customer(customerService.findCustomerById(purchase.getCustomer().getId()).get(0))
                        .purchaseDate(purchase.getPurchaseDate().toString())
                        .build())
                .collect(Collectors.toList());
    }
}
