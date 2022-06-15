package com.example.hortfruit.controller.supplier;

import com.example.hortfruit.controller.product.ProductController;
import com.example.hortfruit.model.supplier.dto.SupplierDTO;
import com.example.hortfruit.model.supplier.dto.SupplierDTOResponse;
import com.example.hortfruit.service.supplier.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("public/v1/suppliers")
@Api(value = "Suppliers API")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductController productController;

    @GetMapping
    @ApiOperation(value = "Find All Suppliers", response = String.class, notes = "Find All Suppliers")
    public ResponseEntity<?> findAllSupplier() {
        return ResponseEntity.ok(supplierService.findAllSupplier());
    }

    @PostMapping
    @ApiOperation(value = "Create a new Supplier", response = String.class, notes = "Create a new Supplier")
    public ResponseEntity<?> createNewSupplier(@RequestBody SupplierDTO supplierDTO,
                                               UriComponentsBuilder builder){
        final SupplierDTOResponse createdSupplier = supplierService.createNewSupplier(supplierDTO);
        final URI uri = builder.path("/supplier/{id}").buildAndExpand(createdSupplier.getId()).toUri();
        return ResponseEntity.created(uri).body(createdSupplier);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Supplier By Id", response = String.class, notes = "Find Supplier By Id")
    public ResponseEntity<?> findSupplierById(@PathVariable @Validated Long id){

        return ResponseEntity.ok(supplierService.findSupplierById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplierById(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        supplierService.updateSupplierById(id, supplierDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplierById(@PathVariable Long id){
        supplierService.deleteSupplierById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> findAllProductsBySupplierId(@PathVariable Long id){
        return ResponseEntity.ok(productController.findAllProductsBySupplierId(id).getBody());
    }
}
