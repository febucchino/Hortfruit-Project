package com.example.hortfruit.service.product;

import com.example.hortfruit.model.product.Availability;
import com.example.hortfruit.model.product.Product;
import com.example.hortfruit.model.product.ProductScenarios;
import com.example.hortfruit.model.product.dto.ProductDTO;
import com.example.hortfruit.model.product.dto.ProductDTOResponse;
import com.example.hortfruit.repository.product.ProductRepository;
import com.example.hortfruit.repository.product.ProductStrategyRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    private Map<ProductScenarios, ProductStrategyRepository> produtoScenariosStrategy;

    private MultiKeyMap multiKeyMap = new MultiKeyMap();


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTOResponse> findAllProduct(){
        return productRepository.findAll()
                .stream()
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductDTOResponse createNewProduct(Product product){

        ProductDTOResponse newProduct = productRepository.save(product).toDTO();

        return newProduct;

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
                        .build())
                .collect(Collectors.toList());
    }

    public List<ProductDTOResponse> findProductByAvailability() {

        List<Product> availableProducts = productRepository.findAll();

        return availableProducts
                .stream()
                .filter(product -> Availability.DISPONIVEL.equals(product.getAvailability()))
                .map(product -> ProductDTOResponse
                        .builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .availability(product.getAvailability())
                        .build())
                .collect(Collectors.toList());

    }

    @Transactional
    public void updateProductById(Long id, ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(id);

        if (!productDTO.getProductName().isBlank()) {
            product.get().setProductName(productDTO.getProductName());
        }
        if (!productDTO.getPrice().toString().isBlank()) {
            product.get().setPrice(productDTO.getPrice());
        }
        if (!productDTO.getQuantity().toString().isBlank()) {
            product.get().setQuantity(productDTO.getQuantity());
        }
        if (!productDTO.getAvailability().toString().isBlank()) {
            product.get().setAvailability(productDTO.getAvailability());
        }
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
