package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.PermissionDTO;
import kz.yeldos.delivery.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/permission")
public class PermissionRestController {
    private final PermissionService permissionService;

    @GetMapping
    public List<PermissionDTO> permissionList(){
        return permissionService.getPermissions();
    }

    @GetMapping(value = "{id}")
    public PermissionDTO getPermission(@PathVariable(name="id") Long id){
        return permissionService.getPermission(id);
    }

    @PostMapping
    public PermissionDTO addPermission(@RequestBody PermissionDTO permission){
        return permissionService.addPermission(permission);
    }

    @PutMapping
    public PermissionDTO updatePermission(@RequestBody PermissionDTO permission){
        return permissionService.updatePermission(permission);
    }

    @DeleteMapping(value = "{id}")
    public void deletePermission(@PathVariable(name="id") Long id){
        permissionService.deletePermission(id);
    }

}
