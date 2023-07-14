package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.UserDTO;
import kz.yeldos.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> userList(){
        return userService.getUsers();
    }

    @GetMapping(value="{id}")
    public UserDTO getUser(@PathVariable(name="id") Long id){
        return userService.getUser(id);
    }
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }
    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO user){
        return userService.updateUser(user);
    }
    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(name="id") Long id){
        userService.deleteUser(id);
    }

}
