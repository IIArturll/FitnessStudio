package fitness.services.user;

import fitness.core.user.dtos.UserDTO;
import fitness.core.user.dtos.UserLoginDTO;
import fitness.core.user.dtos.UserRegistrationDTO;
import fitness.core.user.dtos.enums.UserStatus;
import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.user.mappers.UserConverter;
import fitness.dao.repositories.user.api.IPersonalAccountRepository;
import fitness.dao.repositories.user.entity.UserEntity;
import fitness.dao.repositories.user.entity.UserStatusEntity;
import fitness.services.user.api.IPersonalAccountService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PersonalAccountService implements IPersonalAccountService {

    private final IPersonalAccountRepository repository;
    private final UserConverter converter;

    public PersonalAccountService(IPersonalAccountRepository repository, UserConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    public void register(UserRegistrationDTO user) {
        UserEntity entity = converter.converToUserEntity(user);
        entity.setDtCreate(Instant.now());
        entity.setDtUpdate(Instant.now());
        repository.save(entity);
    }

    @Override
    public void verified(String code, String mail) throws SingleErrorResponse {
        UserEntity user = repository.findByMail(mail).orElseThrow(() ->
                new SingleErrorResponse("no such element", "unknown mail"));
        if (user.getUuid().toString().equals(code)) {
            user.setStatus(new UserStatusEntity(UserStatus.ACTIVATED));
            repository.save(user);
        } else {
            throw new SingleErrorResponse("NO", "incorrect code");
        }
    }

    @Override
    public void login(UserLoginDTO user) {

    }

    @Override
    public UserDTO get(UUID uuid) {
        return null;
    }
}
