package fitness.services.nutrition.api;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.RecipeDTO;
import fitness.core.nutrition.dtos.RecipeForCUDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.UUID;

public interface IRecipeService {
    void add(RecipeForCUDTO recipe) throws SingleErrorResponse;

    Page<RecipeDTO> getPage(Pageable pageable);

    void update(UUID uuid, Instant dtUpdate, RecipeForCUDTO recipe) throws SingleErrorResponse;
}
