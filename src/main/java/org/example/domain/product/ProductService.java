package org.example.domain.product;

import org.springframework.stereotype.Service;
import org.example.domain.product.ProductRequestDTO;
import org.example.domain.product.ProductResponseDTO;
import org.example.domain.product.ProductMapper;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {
    private final Map<UUID, Product> products = new ConcurrentHashMap<>();
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getAllProducts() {
        return null;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }

    public ProductResponseDTO getProductDtoById(UUID id) {
        return null;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productDto) {
        return null;
    }

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productDto) {
        return null;
    }

    public boolean deleteProduct(UUID id) {
        return false;
    }

    public boolean existsById(UUID id) {
        return false;
    }
}
