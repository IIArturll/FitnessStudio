package fitness.web.controllers.nutrition;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.ProductDTO;
import fitness.services.nutrition.api.IProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ProductDTO product) {
        service.add(product);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getPage(Pageable pageable){
        return ResponseEntity.status(200).body(service.getPage(pageable));
    }

    @PostMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<?>update(@PathVariable(name = "uuid")UUID uuid,
                                   @PathVariable(name = "dt_update") Long dt_update,
                                   @Valid @RequestBody ProductDTO productDTO) throws SingleErrorResponse {
        service.update(uuid,dt_update,productDTO);
        return ResponseEntity.status(200).build();
    }
}
