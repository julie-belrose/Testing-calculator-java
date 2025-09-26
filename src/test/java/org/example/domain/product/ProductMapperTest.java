package org.example.domain.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperTest {

    private UUID productId;
    private Product sampleProduct;
    private ProductRequestDTO sampleRequestDTO;

    @BeforeEach
    void setUp() {
        productId = UUID.randomUUID();
        sampleProduct = Product.builder()
                .id(productId)
                .name("Test Product")
                .description("Test Description")
                .price(BigDecimal.valueOf(99.99))
                .stock(10)
                .build();

        sampleRequestDTO = new ProductRequestDTO(
                "New Product",
                "New Description",
                BigDecimal.valueOf(149.99),
                5
        );
    }

    private void assertProductEquals(Product product,
                                     BigDecimal expectedPrice) {
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("New Product");
        assertThat(product.getDescription()).isEqualTo("New Description");
        assertThat(product.getPrice()).isEqualTo(expectedPrice);
        assertThat(product.getStock()).isEqualTo((Integer) 5);
    }

    private void assertResponseDTOEquals(ProductResponseDTO dto, UUID expectedId,
                                         BigDecimal expectedPrice) {
        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(expectedId);
        assertThat(dto.name()).isEqualTo("Test Product");
        assertThat(dto.description()).isEqualTo("Test Description");
        assertThat(dto.price()).isEqualTo(expectedPrice);
        assertThat(dto.stock()).isEqualTo((Integer) 10);
    }

    @Test
    @DisplayName("Should convert Product entity to ProductResponseDTO")
    void toResponseDTO() {
        // When
        ProductResponseDTO result = ProductMapper.toResponseDTO(sampleProduct);

        // Then
        assertResponseDTOEquals(result, productId,
                BigDecimal.valueOf(99.99));
    }

    @Test
    @DisplayName("Should convert ProductRequestDTO to Product entity")
    void toEntity() {
        // When
        Product result = ProductMapper.toEntity(sampleRequestDTO);

        // Then
        assertThat(result.getId()).isNull(); // ID should not be set
        assertProductEquals(result,
                BigDecimal.valueOf(149.99));
    }

    @Test
    @DisplayName("Should update existing Product entity with ProductRequestDTO data")
    void updateEntity() {
        // Given
        UUID productId = UUID.randomUUID();
        Product existingProduct = Product.builder()
                .id(productId)
                .name("Old Product")
                .description("Old Description")
                .price(BigDecimal.valueOf(50.00))
                .stock(20)
                .build();

        ProductRequestDTO updateDTO = new ProductRequestDTO(
                "Updated Product",
                "Updated Description",
                BigDecimal.valueOf(75.50),
                15
        );

        // When
        ProductMapper.updateEntity(existingProduct, updateDTO);

        // Then
        assertThat(existingProduct.getId()).isEqualTo(productId); // ID should remain unchanged
        assertThat(existingProduct.getName()).isEqualTo("Updated Product");
        assertThat(existingProduct.getDescription()).isEqualTo("Updated Description");
        assertThat(existingProduct.getPrice()).isEqualTo(BigDecimal.valueOf(75.50));
        assertThat(existingProduct.getStock()).isEqualTo(15);
    }

    @Test
    @DisplayName("Should handle null values in toResponseDTO")
    void toResponseDTO_withNullValues() {
        // Given
        Product product = Product.builder()
                .id(UUID.randomUUID())
                .name("Product")
                .description(null) // null description
                .price(BigDecimal.valueOf(10.00))
                .stock(1)
                .build();

        // When
        ProductResponseDTO result = ProductMapper.toResponseDTO(product);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.description()).isNull();
        assertThat(result.name()).isEqualTo("Product");
    }

    @Test
    @DisplayName("Should handle null values in updateEntity")
    void updateEntity_withNullValues() {
        // Given
        Product existingProduct = Product.builder()
                .id(UUID.randomUUID())
                .name("Original")
                .description("Original Description")
                .price(BigDecimal.valueOf(100.00))
                .stock(10)
                .build();

        ProductRequestDTO updateDTO = new ProductRequestDTO(
                "Updated",
                null, // null description
                BigDecimal.valueOf(200.00),
                20
        );

        // When
        ProductMapper.updateEntity(existingProduct, updateDTO);

        // Then
        assertThat(existingProduct.getName()).isEqualTo("Updated");
        assertThat(existingProduct.getDescription()).isNull();
        assertThat(existingProduct.getPrice()).isEqualTo(BigDecimal.valueOf(200.00));
        assertThat(existingProduct.getStock()).isEqualTo(20);
    }
}
