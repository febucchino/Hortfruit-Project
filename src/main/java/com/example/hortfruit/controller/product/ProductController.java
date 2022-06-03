package com.example.hortfruit.controller.product;

import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.product.dto.ProductDTO;
import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import com.example.hortfruit.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

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
    public ResponseEntity<?> createNewProduct(@RequestBody Product product,
                                              UriComponentsBuilder builder) {
        final ProductDTOResponse createdProduct = productService.createNewProduct(product);
        final URI uri = builder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(createdProduct);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Find Product By Id", response = String.class, notes = "Find Product By Id")
    public ResponseEntity<?> findProductByName(@PathVariable Long id){

        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/available")
    @ApiOperation(value = "Find All Available's Products", response = String.class, notes = "Find All Available's Products")
    public ResponseEntity<?> findProductByAvailability() {

        return ResponseEntity.ok(productService.findProductByAvailability());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProductById(id, productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
