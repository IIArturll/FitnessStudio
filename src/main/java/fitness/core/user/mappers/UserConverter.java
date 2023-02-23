package fitness.core.user.mappers;

import fitness.core.user.dtos.UserDTO;
import fitness.core.user.dtos.UserRegistrationDTO;
import fitness.core.user.dtos.enums.UserRole;
import fitness.core.user.dtos.enums.UserStatus;
import fitness.dao.repositories.user.entity.UserEntity;
import fitness.dao.repositories.user.entity.UserRoleEntity;
import fitness.dao.repositories.user.entity.UserStatusEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class UserConverter {
    private final ModelMapper modelMapper;

    public UserConverter() {
        this.modelMapper = new ModelMapper();
    }

    public UserDTO convertToUserDTO(UserEntity entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    public UserEntity convertToUserEntity(UserDTO userDTO){
        UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
        entity.setRole(new UserRoleEntity(userDTO.getRole()));
        entity.setStatus(new UserStatusEntity(userDTO.getStatus()));
        return entity;
    }

    public UserEntity converToUserEntity(UserRegistrationDTO userDTO){
        UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(Instant.now());
        entity.setDtUpdate(Instant.now());
        entity.setRole(new UserRoleEntity(UserRole.USER));
        entity.setStatus(new UserStatusEntity(UserStatus.WAITING_ACTIVATION));
        return entity;
    }
}
