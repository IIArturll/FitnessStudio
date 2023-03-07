package fitness.dao.repositories.user.api;

import fitness.dao.repositories.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IUserRepository extends PagingAndSortingRepository<UserEntity, UUID>,
        CrudRepository<UserEntity, UUID> {

}
