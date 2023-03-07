package fitness.web.controllers.nutrition;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.RecipeDTO;
import fitness.core.nutrition.dtos.RecipeForCUDTO;
import fitness.services.nutrition.api.IRecipeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    private final IRecipeService service;

    public RecipeController(IRecipeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody RecipeForCUDTO recipe) throws SingleErrorResponse {
        service.add(recipe);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<Page<RecipeDTO>> getPage(Pageable pageable) {
        return ResponseEntity.status(200).body(service.getPage(pageable));
    }

    @PutMapping(value = "/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update") Instant dtUpdate,
                                    @Valid @RequestBody RecipeForCUDTO recipe) throws SingleErrorResponse {
        service.update(uuid, dtUpdate, recipe);
        return ResponseEntity.status(200).build();
    }
}
