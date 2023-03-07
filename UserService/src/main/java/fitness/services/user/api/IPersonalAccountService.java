package fitness.services.user.api;

import fitness.core.user.dtos.UserDTO;
import fitness.core.user.dtos.UserLoginDTO;
import fitness.core.user.dtos.UserRegistrationDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;

import java.util.UUID;

public interface IPersonalAccountService {

    void register(UserRegistrationDTO user) throws MultipleErrorResponse;

    void verified(String code, String mail) throws SingleErrorResponse;

    void login(UserLoginDTO user);

    UserDTO get(UUID uuid);
}
