package fitness.core.user.mappers;

import fitness.core.user.dtos.UserCreateDTO;
import fitness.core.user.dtos.UserDTO;
import fitness.core.user.dtos.UserRegistrationDTO;
import fitness.core.user.dtos.enums.UserRole;
import fitness.core.user.dtos.enums.UserStatus;
import fitness.dao.repositories.user.entity.UserEntity;
import fitness.dao.repositories.user.entity.UserRoleEntity;
import fitness.dao.repositories.user.entity.UserStatusEntity;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {

    public UserConverter() {

    }

    public UserDTO convertToUserDTO(UserEntity entity) {
        return new UserDTO(entity.getUuid(), entity.getDtCreate(),
                entity.getDtUpdate(), entity.getMail(),
                entity.getFio(), entity.getRole().getRole(), entity.getStatus().getStatus());
    }

    public UserEntity convertToUserEntity(UserCreateDTO user) {
        UserEntity entity = new UserEntity();
        entity.setMail(user.getMail());
        entity.setFio(user.getFio());
        entity.setRole(new UserRoleEntity(user.getRole()));
        entity.setStatus(new UserStatusEntity(user.getStatus()));
        entity.setPassword(user.getPassword());
        return entity;
    }

    public UserEntity converToUserEntity(UserRegistrationDTO userDTO) {
        UserEntity entity = new UserEntity();
        entity.setMail(userDTO.getMail());
        entity.setFio(userDTO.getFio());
        entity.setPassword(userDTO.getPassword());
        entity.setRole(new UserRoleEntity(UserRole.USER));
        entity.setStatus(new UserStatusEntity(UserStatus.WAITING_ACTIVATION));
        return entity;
    }
}
