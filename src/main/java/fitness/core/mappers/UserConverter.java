package fitness.core.mappers;

import fitness.core.dtos.UserDTO;
import fitness.dao.repositories.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
        return modelMapper.map(userDTO,UserEntity.class);
    }
}
