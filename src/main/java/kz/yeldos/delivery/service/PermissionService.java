package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.PermissionDTO;
import kz.yeldos.delivery.mapper.PermissionMapper;
import kz.yeldos.delivery.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService{
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;
    public List<PermissionDTO> getPermissions(){
        return permissionMapper.toDtoList(permissionRepository.findAll());
    }
    public PermissionDTO getPermission(Long id){
        return permissionMapper.toDto(permissionRepository.findById(id).orElse(null));
    }

    public PermissionDTO addPermission(PermissionDTO permissionDTO){
        return permissionMapper.toDto(permissionRepository.save(permissionMapper.toModel(permissionDTO)));
    }
    public PermissionDTO updatePermission(PermissionDTO permissionDTO){
        return permissionMapper.toDto(permissionRepository.save(permissionMapper.toModel(permissionDTO)));
    }
    public void deletePermission(Long id){
        permissionRepository.deleteById(id);
    }

}
