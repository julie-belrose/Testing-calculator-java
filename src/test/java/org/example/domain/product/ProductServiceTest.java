package org.example.domain.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = org.example.app.App.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    private List<Product> products;

    @BeforeEach
    public void setup() {
        products = List.of(
                Product.builder().id(UUID.randomUUID()).name("Banana").description("Potassium!")
                        .price(new BigDecimal(1.29)).stock(500).build(),
                Product.builder().id(UUID.randomUUID()).name("Nintendo Switch 2").description("C'est l'arnaque!")
                        .price(new BigDecimal(499.99)).stock(900).build());
    }

    @Test
    @DisplayName("Get all Products")
    void getAllProducts() {
        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductResponseDTO> result = productService.getAllProducts();

        assertThat(result).hasSize(products.size());
    }

    @Test
    @DisplayName("Get a specific product")
    void getProductById() {
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(products.get(0)));

        ProductResponseDTO result = productService.getProductDtoById(products.get(0).getId());

        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo(products.get(0).getName());
        assertThat(result.description()).isEqualTo(products.get(0).getDescription());
        assertThat(result.price()).isEqualTo(products.get(0).getPrice());
        assertThat(result.stock()).isEqualTo(products.get(0).getStock());
    }

    @Test
    @DisplayName("Create a new product")
    void createProduct() {
        ProductRequestDTO request = new ProductRequestDTO("Loup-Garou de Thiercellieux", "Super jeu !",
                new BigDecimal(16.95), 25);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(products.get(0));

        ProductResponseDTO saved = productService.createProduct(request);

        assertThat(saved).isNotNull();
        assertThat(saved.id()).isEqualTo(products.get(0).getId());
        assertThat(saved.name()).isEqualTo(products.get(0).getName());
        assertThat(saved.description()).isEqualTo(products.get(0).getDescription());
        assertThat(saved.price()).isEqualTo(products.get(0).getPrice());
        assertThat(saved.stock()).isEqualTo(products.get(0).getStock());
    }
}