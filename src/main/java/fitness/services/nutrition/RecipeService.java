package fitness.services.nutrition;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.RecipeDTO;
import fitness.core.nutrition.dtos.RecipeForCUDTO;
import fitness.core.nutrition.mappers.RecipeConverter;
import fitness.dao.repositories.nutrition.api.IRecipeRepository;
import fitness.dao.repositories.nutrition.entity.RecipeEntity;
import fitness.services.nutrition.api.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RecipeService implements IRecipeService {

    private final IRecipeRepository repository;
    private final RecipeConverter converter;


    public RecipeService(IRecipeRepository repository, RecipeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void add(RecipeForCUDTO recipe) throws SingleErrorResponse {
        RecipeEntity entity = converter.convertToRecipeEntity(recipe);
        entity.setDtCreate(Instant.now());
        repository.save(entity);
    }

    @Override
    public Page<RecipeDTO> getPage(Pageable pageable) {
        return repository.findAll(pageable).map(converter::convertTORecipeDTO);
    }

    @Override
    public void update(UUID uuid, Instant dtUpdate, RecipeForCUDTO recipe)
            throws SingleErrorResponse {
        RecipeEntity entity = repository.findById(uuid).orElseThrow(() ->
                new SingleErrorResponse("err",
                        "recipe with this id: " + uuid + " not found"));
        if (entity.getDtUpdate().toEpochMilli() != dtUpdate.toEpochMilli()) {
            throw new SingleErrorResponse("err",
                    "recipe already has been update");
        }
        var newEntity = converter.convertToRecipeEntity(recipe);
        entity.setComposition(newEntity.getComposition());
        entity.setTitle(newEntity.getTitle());
        repository.save(entity);
    }


}
