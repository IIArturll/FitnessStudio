package fitness.core.nutrition.mappers;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.ProductCompositionDTO;
import fitness.core.nutrition.dtos.RecipeDTO;
import fitness.core.nutrition.dtos.RecipeForCUDTO;
import fitness.dao.repositories.nutrition.entity.ProductEntity;
import fitness.dao.repositories.nutrition.entity.ProductModelEntity;
import fitness.dao.repositories.nutrition.entity.RecipeEntity;
import fitness.services.nutrition.api.IProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeConverter {
    private final IProductService productService;
    private final ProductConverter productConverter;

    public RecipeConverter(IProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    public RecipeEntity convertToRecipeEntity(RecipeForCUDTO recipeDTO) throws SingleErrorResponse {
        RecipeEntity entity = new RecipeEntity();
        entity.setTitle(recipeDTO.getTitle());
        List<ProductModelEntity> list = new ArrayList<>();
        for (var c : recipeDTO.getComposition()) {
            ProductEntity productEntity = productService.find(c.getProduct());
            list.add(new ProductModelEntity(productEntity, c.getWeight()));
        }
        entity.setComposition(list);
        return entity;
    }

    public RecipeDTO convertTORecipeDTO(RecipeEntity entity) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setUuid(entity.getUuid());
        recipeDTO.setDtCreate(entity.getDtCreate());
        recipeDTO.setDtUpdate(entity.getDtUpdate());
        recipeDTO.setTitle(entity.getTitle());
        List<ProductCompositionDTO> compositionDTOS = entity.getComposition().stream()
                .map(productConverter::convertToProductCompositionDTO).toList();
        recipeDTO.setComposition(compositionDTOS);
        recipeDTO.setWeight(countWeight(compositionDTOS));
        recipeDTO.setCalories(countCalories(compositionDTOS));
        recipeDTO.setProteins(countProteins(compositionDTOS));
        recipeDTO.setFats(countFats(compositionDTOS));
        recipeDTO.setCarbohydrates(countCarbohydrates(compositionDTOS));
        return recipeDTO;
    }

    private Integer countWeight(List<ProductCompositionDTO> list) {
        return list.stream().mapToInt(ProductCompositionDTO::getWeight).sum();
    }

    private Integer countCalories(List<ProductCompositionDTO> list) {
        return list.stream().mapToInt(ProductCompositionDTO::getCalories).sum();
    }

    private Double countProteins(List<ProductCompositionDTO> list) {
        return list.stream().mapToDouble(ProductCompositionDTO::getProteins).sum();
    }

    private Double countFats(List<ProductCompositionDTO> list) {
        return list.stream().mapToDouble(ProductCompositionDTO::getFats).sum();
    }

    private Double countCarbohydrates(List<ProductCompositionDTO> list) {
        return list.stream().mapToDouble(ProductCompositionDTO::getCarbohydrates).sum();
    }
}

