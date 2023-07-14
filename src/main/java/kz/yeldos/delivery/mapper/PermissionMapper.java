package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.PermissionDTO;
import kz.yeldos.delivery.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionDTO toDto(Permission permission);
    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissionList);

    List<Permission> toModelList(List<PermissionDTO> permissionDTOList);
}
