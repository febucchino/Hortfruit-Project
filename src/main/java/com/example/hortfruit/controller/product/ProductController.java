package com.example.hortfruit.controller.product;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.product.dto.ProductDTO;
import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import com.example.hortfruit.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("public/v1/products")
@Api(value = "Products API")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "Find All Product", response = String.class, notes = "Find All Product")
    public ResponseEntity<?> findAllProduct() {
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @PostMapping
    @ApiOperation(value = "Create a new Product", response = String.class, notes = "Create a new Product")
    public ResponseEntity<?> createNewProduct(@RequestBody ProductDTO product,
                                              UriComponentsBuilder builder) {
        final ProductDTOResponse createdProduct = productService.createNewProduct(product);
        final URI uri = builder.path("/products/{id}").buildAndExpand(createdProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(createdProduct);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Product By Id", response = String.class, notes = "Find Product By Id")
    public ResponseEntity<?> findProductById(@PathVariable @Validated Long id){

        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/available")
    @ApiOperation(value = "Find Products by Availability", response = String.class, notes = "Find Products by Availability")
    public ResponseEntity<?> findProductByAvailability(@RequestParam("availability") Availability availability) {

        return ResponseEntity.ok(productService.findProductByAvailability(availability));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Product By Id", response = String.class, notes = "Update Product By Id")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProductById(id, productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Product By Id", response = String.class, notes = "Delete Product By Id")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suppliers/{supplierId}")
    public ResponseEntity<?> findAllProductsBySupplierId(@PathVariable Long supplierId){
        return ResponseEntity.ok(productService.findAllProductsBySupplierId(supplierId));
    }
}
