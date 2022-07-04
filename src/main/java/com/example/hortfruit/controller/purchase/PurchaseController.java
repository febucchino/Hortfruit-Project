package com.example.hortfruit.controller.purchase;

import com.example.hortfruit.service.purchase.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/v1/purchases")
@Api(value = "Purchase API")
public class PurchaseController {

    @Autowired
    public PurchaseService purchaseService;

    @GetMapping
    @ApiOperation(value = "Find All Purchase", response = String.class, notes = "Find All Purchase")
    public ResponseEntity<?> findAllPurchase() {
        return ResponseEntity.ok(purchaseService.findAllPurchase());
    }
}
