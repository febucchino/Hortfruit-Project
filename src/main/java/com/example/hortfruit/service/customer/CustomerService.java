package com.example.hortfruit.service.customer;

import com.example.hortfruit.model.customer.Customer;
import com.example.hortfruit.model.customer.dto.CustomerDTO;
import com.example.hortfruit.model.customer.dto.CustomerDTOResponse;
import com.example.hortfruit.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDTOResponse> findAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerDTOResponse
                        .builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .cpf(customer.getCpf())
                        .telephone(customer.getTelephone())
                        .address(customer.getAddress())
                        .build())
                .collect(Collectors.toList());
    }

    public CustomerDTOResponse createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerDTO.convertToCustomer();
        return customerRepository.save(customer).toDTO();

    }

    public List<CustomerDTOResponse> findCustomerById(Long id) {
        return customerRepository.findById(id)
                .stream()
                .map(customer -> CustomerDTOResponse
                        .builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .cpf(customer.getCpf())
                        .telephone(customer.getTelephone())
                        .address(customer.getAddress())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateCustomerById(Long id, CustomerDTO customerDTO) {
        customerRepository.findById(id)
                .map(customer -> Customer
                        .builder()
                        .id(id)
                        .name(customerDTO.getName())
                        .cpf(customerDTO.getCpf())
                        .telephone(customerDTO.getTelephone())
                        .address(customer.getAddress())
                        .build())
                .ifPresent(customerRepository::save);
    }

    @Transactional
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
