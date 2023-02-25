package fitness.services.nutrition.api;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IProductService {
    void add(ProductDTO product);

    Page<ProductDTO> getPage(Pageable pageable);

    void update(UUID uuid,Long dt_update,ProductDTO product) throws SingleErrorResponse;
}
