package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.UserDTO;
import kz.yeldos.delivery.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toModel(UserDTO user);
    List<User> toModelList(List<UserDTO> userDTOList);
    List<UserDTO> toDtoList(List<User> userList);
}
