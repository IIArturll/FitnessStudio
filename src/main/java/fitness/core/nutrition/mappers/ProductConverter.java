package fitness.core.nutrition.mappers;

import fitness.core.nutrition.dtos.ProductCompositionDTO;
import fitness.core.nutrition.dtos.ProductDTO;
import fitness.dao.repositories.nutrition.entity.ProductEntity;
import fitness.dao.repositories.nutrition.entity.ProductModelEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductConverter() {
    }

    public ProductEntity convertToEntity(ProductDTO product) {
        return new ProductEntity(product.getTitle(), product.getWeight(),
                product.getCalories(), product.getProteins(), product.getFats(),
                product.getCarbohydrates());
    }

    public ProductDTO convertToProductDTO(ProductEntity product) {
        return new ProductDTO(product.getUuid(), product.getDtCreate(),
                product.getDtUpdate(), product.getTitle(), product.getWeight(),
                product.getCalories(), product.getProteins(),
                product.getFats(), product.getCarbohydrates());
    }


    public ProductCompositionDTO convertToProductCompositionDTO(ProductModelEntity productModel) {
        ProductCompositionDTO compositionDTO = new ProductCompositionDTO(
                convertToProductDTO(productModel.getProduct()));
        compositionDTO.setWeight(productModel.getWeight());
        var prod = productModel.getProduct();
        double koef = (double) productModel.getWeight() / prod.getWeight();
        compositionDTO.setCalories((int) Math.round(koef * prod.getCalories()));
        compositionDTO.setProteins(koef * prod.getProteins());
        compositionDTO.setFats(koef * prod.getFats());
        compositionDTO.setCarbohydrates(koef * prod.getCarbohydrates());
        return compositionDTO;
    }
}
