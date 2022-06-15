package com.example.hortfruit.service.supplier;

import com.example.hortfruit.model.supplier.Supplier;
import com.example.hortfruit.model.supplier.dto.SupplierDTO;
import com.example.hortfruit.model.supplier.dto.SupplierDTOResponse;
import com.example.hortfruit.repository.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTOResponse> findAllSupplier() {
        return supplierRepository.findAll()
                .stream()
                .map(supplier -> SupplierDTOResponse
                        .builder()
                        .id(supplier.getId())
                        .companyName(supplier.getCompanyName())
                        .cnpj(supplier.getCnpj())
                        .telephone(supplier.getTelephone())
                        .email(supplier.getEmail())
                        .build())
                .collect(Collectors.toList());
    }


    public SupplierDTOResponse createNewSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierDTO.convertToSupplier();
        return supplierRepository.save(supplier).toDTO();
    }


    public List<SupplierDTOResponse> findSupplierById(Long id) {

        SupplierDTOResponse supplierResponse = new SupplierDTOResponse();

        return supplierRepository.findById(id)
                .stream()
                .map(supplier -> SupplierDTOResponse
                        .builder()
                        .id(supplier.getId())
                        .companyName(supplier.getCompanyName())
                        .cnpj(supplier.getCnpj())
                        .telephone(supplier.getTelephone())
                        .email(supplier.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateSupplierById(Long id, SupplierDTO supplierDTO) {
        supplierRepository.findById(id)
                .map(supplier -> Supplier
                        .builder()
                        .id(id)
                        .companyName(supplierDTO.getCompanyName())
                        .cnpj(supplierDTO.getCnpj())
                        .telephone(supplierDTO.getTelephone())
                        .email(supplierDTO.getEmail())
                        .build())
                .ifPresent(supplierRepository::save);
    }

    @Transactional
    public void deleteSupplierById(Long id) {
        supplierRepository.deleteById(id);
    }
}
