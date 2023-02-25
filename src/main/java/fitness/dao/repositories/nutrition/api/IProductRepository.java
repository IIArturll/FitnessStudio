package fitness.dao.repositories.nutrition.api;

import fitness.dao.repositories.nutrition.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, UUID>,
        PagingAndSortingRepository<ProductEntity, UUID> {
}
