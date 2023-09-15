package com.example.hortfruit.controller.purchase;

import com.example.hortfruit.service.purchase.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("purchase/{purchaseNumber}")
    @ApiOperation(value = "Find Purchase by Purchase Number", response = String.class, notes = "Find Purchase by Purchase Number")
    public ResponseEntity<?> findPurchaseByPurchaseNumber(@PathVariable @Validated int purchaseNumber) {
        return ResponseEntity.ok(purchaseService.findPurchaseByPurchaseNumber(purchaseNumber));
    }

    @GetMapping("customer/{customerId}")
    @ApiOperation(value = "Find Purchase by Customer Id", response = String.class, notes = "Find Purchase by Customer Id")
    public ResponseEntity<?> findPurchaseByCustomerId(@PathVariable @Validated Long customerId) {
        return ResponseEntity.ok(purchaseService.findPurchaseByCustomerId(customerId));
    }

//    @GetMapping("date-purchase")
//    @ApiOperation(value = "Find Purchase between a determined date", response = String.class, notes = "Find Purchase between a determined date")
//    public ResponseEntity<?> findPurchaseBetweenDate(@RequestParam("datePurchaseFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                                 LocalDate datePurchaseFrom,
//                                                     @RequestParam("datePurchaseTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                                 LocalDate datePurchaseTo)
}
