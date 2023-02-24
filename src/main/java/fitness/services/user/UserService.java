package fitness.services.user;

import fitness.core.user.dtos.UserCreateDTO;
import fitness.core.user.dtos.UserDTO;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;
import fitness.core.user.mappers.UserConverter;
import fitness.dao.repositories.user.api.IUserRepository;
import fitness.dao.repositories.user.entity.UserEntity;
import fitness.dao.repositories.user.entity.UserRoleEntity;
import fitness.dao.repositories.user.entity.UserStatusEntity;
import fitness.services.user.api.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final IUserRepository repository;
    private final UserConverter converter;

    public UserService(IUserRepository repository, UserConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void create(UserCreateDTO user) throws MultipleErrorResponse {
        user.validate();
        UserEntity entity = converter.convertToUserEntity(user);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(Instant.now());
        entity.setDtUpdate(Instant.now());
        repository.save(entity);
    }

    @Override
    public UserDTO get(UUID uuid) throws SingleErrorResponse {
        UserEntity user = repository.findById(uuid).orElseThrow(() ->
                new SingleErrorResponse("NoSuchElement", "unknown uuid"));
        return converter.convertToUserDTO(user);
    }

    @Override
    public void update(UUID uuid, Long dt_update, UserCreateDTO createDTO)
            throws SingleErrorResponse, MultipleErrorResponse {
        createDTO.validate();
        UserEntity user = repository.findById(uuid).orElseThrow(() ->
                new SingleErrorResponse("NoSuchElement", "unknown uuid"));
        if (dt_update != user.getDtUpdate().toEpochMilli()) {
            throw new SingleErrorResponse("error", "user has already been updated");
        }
        user.setMail(createDTO.getMail());
        user.setFio(createDTO.getFio());
        user.setRole(new UserRoleEntity(createDTO.getRole()));
        user.setStatus(new UserStatusEntity(createDTO.getStatus()));
        user.setPassword(createDTO.getPassword());
        repository.save(user);
    }

    @Override
    public Page<UserDTO> getPage(Pageable pageable) {
        return repository.findAll(pageable).map(converter::convertToUserDTO);
    }
}
