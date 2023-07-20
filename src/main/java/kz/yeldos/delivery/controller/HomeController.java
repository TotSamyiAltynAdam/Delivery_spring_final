package kz.yeldos.delivery.controller;

import kz.yeldos.delivery.dto.UserDTO;
import kz.yeldos.delivery.mapper.PermissionMapper;
import kz.yeldos.delivery.model.Permission;
import kz.yeldos.delivery.model.User;
import kz.yeldos.delivery.service.Additional_blockService;
import kz.yeldos.delivery.service.PermissionService;
import kz.yeldos.delivery.service.RestaurantService;
import kz.yeldos.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private Additional_blockService additionalBlockService;
    @Autowired
    private PermissionMapper permissionMapper;

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in-page")
    public String signInPage(){
        return "signin";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-up-page")
    public String signUpPage(){
        return "signup";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value="/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDenied(){
        return "403";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name="user_email") String email,
                           @RequestParam(name="user_full_name") String fullName,
                           @RequestParam(name="user_password") String password,
                           @RequestParam(name="user_repeat_password") String rePassword){
        if(password.equals(rePassword)) {
            UserDTO user = new UserDTO();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            user.setPreOrder(false);


            List<Permission> permissionList = new ArrayList<>();
            Permission permission = new Permission();
            permission.setId(3L);
            permission.setRole(permissionMapper.toModel(permissionService.getPermission(3L)).getRole());
            permissionList.add(permission);
            user.setPermissions(permissionList);

            UserDTO newUser = userService.addUser(user);
            if(newUser!=null){
                return "redirect:/sign-up-page?success";
            }else{
                return "redirect:/sign-up-page?emailalreadyexist";
            }
        }else{
            return "redirect:/sign-up-page?passwordsmismatch";
        }
    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage(){
        return "update-password";
    }
    @PostMapping(value = "/to-update-password")
    public String toUpdate(@RequestParam(name="user_old_password") String oldPassword,
                           @RequestParam(name="user_new_password") String newPassword,
                           @RequestParam(name="user_repeat_new_password") String reNewPassword){
        if(newPassword.equals(reNewPassword)) {
            User updateUser = userService.updatePassword(oldPassword,newPassword);
            if(updateUser!=null){
                return "redirect:/update-password-page?success";
            }else{
                return "redirect:/update-password-page?oldpassworderror";
            }
        }else{
            return "redirect:/update-password-page?passwordsmismatch";
        }
    }
    @GetMapping(value = "/update-fullName-page")
    public String updateFullNamePage(){
        return "update-fullName";
    }
    @PostMapping(value = "/to-update-fullName")
    public String toUpdate(@RequestParam(name="user_new_full_name") String userNewFullName){
        userService.updateFullName(userNewFullName);
        return "redirect:/update-fullName-page?success";
    }
    @GetMapping(value="/show-me-restaurants")
    public String allRestaurantsPage(){
        return "restaurants";
    }

    @GetMapping(value="/show-me-dishes-relatedToRestaurant/{id}")
    public String allDishesRelatedToParticularRestaurant(@PathVariable(name="id") Long id, Model model){
        model.addAttribute("restaurant",restaurantService.getRestaurant(id));
        return "dishes";
    }
    @GetMapping(value="/show-me-additional-dishes-relatedToAdditionalBlock/{id}")
    public String allAdditionalDishesRelatedToTheParticularAdditionalBlock(@PathVariable(name="id") Long id, Model model){
        model.addAttribute("additionalBlock",additionalBlockService.getAdditionalBlock(id));
        return "additional_dishes";
    }
}
