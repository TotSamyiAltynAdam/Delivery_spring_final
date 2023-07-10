package kz.yeldos.delivery.controller;

import kz.yeldos.delivery.model.User;
import kz.yeldos.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

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
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
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
}
