package org.example.domain.product;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {UUID.class}
)
public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock()
        );
    }

    public static Product toEntity(ProductRequestDTO requestDTO) {
        return new Product(
            requestDTO.name(),
            requestDTO.description(),
            requestDTO.price(),
            requestDTO.stock()
        );
    }

    public static void updateEntity(Product product, ProductRequestDTO requestDTO) {
        product.setName(requestDTO.name());
        product.setDescription(requestDTO.description());
        product.setPrice(requestDTO.price());
        product.setStock(requestDTO.stock());
    }
}
