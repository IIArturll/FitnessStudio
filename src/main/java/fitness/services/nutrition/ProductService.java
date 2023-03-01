package fitness.services.nutrition;

import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.nutrition.dtos.ProductDTO;
import fitness.core.nutrition.mappers.ProductConverter;
import fitness.dao.repositories.nutrition.api.IProductRepository;
import fitness.dao.repositories.nutrition.entity.ProductEntity;
import fitness.services.nutrition.api.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    private final IProductRepository repository;
    private final ProductConverter converter;

    public ProductService(IProductRepository repository, ProductConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void add(ProductDTO product) {
        ProductEntity productEntity = converter.convertToEntity(product);
        productEntity.setUuid(UUID.randomUUID());
        productEntity.setDtCreate(Instant.now());
        productEntity.setDtUpdate(Instant.now());
        repository.save(productEntity);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        return repository.findAll(pageable).map(converter::convertToProductDTO);
    }

    @Override
    public void update(UUID uuid, Long dt_update, ProductDTO product) throws SingleErrorResponse {
        ProductEntity productEntity = repository.findById(uuid).orElseThrow(() ->
                new SingleErrorResponse("err", "no product with this uuid"));
        if (productEntity.getDtUpdate().toEpochMilli() != dt_update) {
            throw new SingleErrorResponse("err", "product already has been update");
        }
        productEntity.setTitle(product.getTitle());
        productEntity.setWeight(product.getWeight());
        productEntity.setCalories(product.getCalories());
        productEntity.setProteins(product.getProteins());
        productEntity.setFats(product.getFats());
        productEntity.setCarbohydrates(product.getCarbohydrates());
        repository.save(productEntity);
    }

    @Override
    public ProductEntity find(UUID uuid) throws SingleErrorResponse {
        return repository.findById(uuid).orElseThrow(()->
                new SingleErrorResponse("err", "no product with this uuid"));
    }
}
