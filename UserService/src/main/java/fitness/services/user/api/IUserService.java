package fitness.services.user.api;

import fitness.core.user.dtos.UserCreateDTO;
import fitness.core.user.dtos.UserDTO;
import fitness.core.exceptions.SingleErrorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.UUID;

public interface IUserService {
    void create(UserCreateDTO user);

    UserDTO get(UUID uuid) throws SingleErrorResponse;

    void update(UUID uuid, Instant dtUpdate, UserCreateDTO user) throws SingleErrorResponse;

    Page<UserDTO> getPage(Pageable pageable);
}
