package fitness.core.nutrition.mappers;

import fitness.core.nutrition.dtos.ProductDTO;
import fitness.dao.repositories.nutrition.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private final ModelMapper modelMapper;

    public ProductConverter() {
        this.modelMapper = new ModelMapper();
    }

    public ProductEntity convertToEntity(ProductDTO product) {
        return modelMapper.map(product, ProductEntity.class);
    }

    public ProductDTO convertToProductDTO(ProductEntity product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
