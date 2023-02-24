package fitness.dao.repositories.user.api;

import fitness.dao.repositories.user.entity.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface IPersonalAccountRepository extends Repository<UserEntity, UUID> {
    Optional<UserEntity> findByMail(String mail);

    void save(UserEntity entity);

    Optional<UserEntity> findById(UUID uuid);

}
