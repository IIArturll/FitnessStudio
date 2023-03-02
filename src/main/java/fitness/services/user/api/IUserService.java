package fitness.services.user.api;

import fitness.core.user.dtos.UserCreateDTO;
import fitness.core.user.dtos.UserDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IUserService {
    void create(UserCreateDTO user) throws MultipleErrorResponse;

    UserDTO get(UUID uuid) throws SingleErrorResponse, MultipleErrorResponse;

    void update(UUID uuid, Long dt_update, UserCreateDTO user) throws SingleErrorResponse, MultipleErrorResponse;

    Page<UserDTO> getPage(Pageable pageable);
}
