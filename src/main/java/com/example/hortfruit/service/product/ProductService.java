package com.example.hortfruit.service.product;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.product.dto.ProductDTO;
import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import com.example.hortfruit.repository.product.ProductRepository;
import com.example.hortfruit.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final SupplierService supplierService;

    public ProductService(ProductRepository productRepository, SupplierService supplierService) {
        this.productRepository = productRepository;
        this.supplierService = supplierService;
    }

    public List<ProductDTOResponse> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .supplier(supplierService.findSupplierById(product.getSupplier().getId()))
                        .build())
                .collect(Collectors.toList());
    }

    public ProductDTOResponse createNewProduct(ProductDTO productDTO) {

        Product product = productDTO.convertToProduct();

        return productRepository.save(product).toDTO();

    }

    public List<ProductDTOResponse> findProductById(Long id) {
        return productRepository.findById(id)
                .stream()
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .supplier(supplierService.findSupplierById(product.getSupplier().getId()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<ProductDTOResponse> findProductByAvailability(Availability availability) {

        List<Product> availableProducts = productRepository.findAll();

        return availableProducts
                .stream()
                .filter(product -> availability.equals(product.getAvailability()))
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .supplier(supplierService.findSupplierById(product.getSupplier().getId()))
                        .build())
                .collect(Collectors.toList());

    }

    @Transactional
    public void updateProductById(Long id, ProductDTO productDTO) {
        productRepository.findById(id)
                .map(product -> Product
                        .builder()
                        .id(id)
                        .productName(productDTO.getProductName())
                        .price(productDTO.getPrice())
                        .quantity(productDTO.getQuantity())
                        .availability(productDTO.getAvailability())
                        .build())
                .ifPresent(productRepository::save);
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTOResponse> findAllProductsBySupplierId(Long supplierId) {
        List<Product> productResponse = productRepository.findProductsBySupplierId(supplierId);
        return productResponse
                .stream()
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .supplier(supplierService.findSupplierById(supplierId))
                        .build())
                .collect(Collectors.toList());
    }
}
