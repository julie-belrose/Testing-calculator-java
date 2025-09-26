package org.example.domain.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductController.class)
@ContextConfiguration(classes = org.example.app.App.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductResponseDTO productResponse;
    private ProductRequestDTO productRequest;
    private UUID productId;

    @BeforeEach
    void setUp() {
        productId = UUID.randomUUID();
        productResponse = new ProductResponseDTO(
                productId,
                "Test Product",
                "Test Description",
                BigDecimal.valueOf(99.99),
                10
        );
        productRequest = new ProductRequestDTO(
                "Test Product",
                "Test Description",
                BigDecimal.valueOf(99.99),
                10
        );
    }

    @Test
    @DisplayName("GET /api/v1/products - Should return all products")
    void getAllProducts() throws Exception {
        List<ProductResponseDTO> products = Arrays.asList(productResponse);
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(productId.toString()))
                .andExpect(jsonPath("$[0].name").value("Test Product"))
                .andExpect(jsonPath("$[0].description").value("Test Description"))
                .andExpect(jsonPath("$[0].price").value(99.99))
                .andExpect(jsonPath("$[0].stock").value(10));
    }

    @Test
    @DisplayName("GET /api/v1/products/{id} - Should return product when found")
    void getProductById_Found() throws Exception {
        when(productService.getProductDtoById(productId)).thenReturn(productResponse);

        mockMvc.perform(get("/api/v1/products/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"))
                .andExpect(jsonPath("$.description").value("Test Description"))
                .andExpect(jsonPath("$.price").value(99.99))
                .andExpect(jsonPath("$.stock").value(10));
    }

    @Test
    @DisplayName("GET /api/v1/products/{id} - Should return 404 when not found")
    void getProductById_NotFound() throws Exception {
        when(productService.getProductDtoById(productId)).thenReturn(null);

        mockMvc.perform(get("/api/v1/products/{id}", productId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/v1/products - Should create product")
    void createProduct() throws Exception {
        when(productService.createProduct(any(ProductRequestDTO.class))).thenReturn(productResponse);

        mockMvc.perform(post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"))
                .andExpect(jsonPath("$.description").value("Test Description"))
                .andExpect(jsonPath("$.price").value(99.99))
                .andExpect(jsonPath("$.stock").value(10));
    }

    @Test
    @DisplayName("PATCH /api/v1/products/{id} - Should update product when found")
    void updateProduct_Found() throws Exception {
        when(productService.updateProduct(eq(productId), any(ProductRequestDTO.class))).thenReturn(productResponse);

        mockMvc.perform(patch("/api/v1/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    @DisplayName("PATCH /api/v1/products/{id} - Should return 404 when not found")
    void updateProduct_NotFound() throws Exception {
        when(productService.updateProduct(eq(productId), any(ProductRequestDTO.class))).thenReturn(null);

        mockMvc.perform(patch("/api/v1/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /api/v1/products/{id} - Should delete product when found")
    void deleteProduct_Found() throws Exception {
        when(productService.deleteProduct(productId)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/products/{id}", productId))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/v1/products/{id} - Should return 404 when not found")
    void deleteProduct_NotFound() throws Exception {
        when(productService.deleteProduct(productId)).thenReturn(false);

        mockMvc.perform(delete("/api/v1/products/{id}", productId))
                .andExpect(status().isNotFound());
    }
}
