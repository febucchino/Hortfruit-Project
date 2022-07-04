package com.example.hortfruit.service.address;

import com.example.hortfruit.model.customer.dto.AddressDTO;
import com.example.hortfruit.repository.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO findAddressByCustomerId(Long customerId) {

        return addressRepository.findAddressByCustomerId(customerId).toDTO();

    }
}
