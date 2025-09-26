package org.example.domain.product;

import org.springframework.stereotype.Service;

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
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }

    public ProductResponseDTO getProductDtoById(UUID id) {
        return productRepository.findById(id)
                .map(ProductMapper::toResponseDTO)
                .orElse(null);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productDto) {
        Product product = ProductMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toResponseDTO(savedProduct);
    }

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productDto) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    ProductMapper.updateEntity(existingProduct, productDto);
                    Product updatedProduct = productRepository.save(existingProduct);
                    return ProductMapper.toResponseDTO(updatedProduct);
                })
                .orElse(null);
    }

    public boolean deleteProduct(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
