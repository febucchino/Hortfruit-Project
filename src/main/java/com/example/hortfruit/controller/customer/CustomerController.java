package com.example.hortfruit.controller.customer;

import com.example.hortfruit.model.customer.dto.CustomerDTO;
import com.example.hortfruit.model.customer.dto.CustomerDTOResponse;
import com.example.hortfruit.service.customer.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("public/v1/customers")
@Api(value = "Customers API")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ApiOperation(value = "Find All Customers", response = String.class, notes = "Find All Customers")
    public ResponseEntity<?> findAllCustomer() {
        return ResponseEntity.ok(customerService.findAllCustomer());
    }

    @PostMapping
    @ApiOperation(value = "Create a new Customer", response = String.class, notes = "Create a new Customer")
    public ResponseEntity<?> createNewCustomer(@RequestBody CustomerDTO customerDTO,
                                               UriComponentsBuilder builder){
        final CustomerDTOResponse createdCustomer = customerService.createNewCustomer(customerDTO);
        final URI uri = builder.path("/customer/{id}").buildAndExpand(createdCustomer.getId()).toUri();
        return ResponseEntity.created(uri).body(createdCustomer);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Customer By Id", response = String.class, notes = "Find Customer By Id")
    public ResponseEntity<?> findCustomerById(@PathVariable @Validated Long id){

        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomerById(id, customerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
