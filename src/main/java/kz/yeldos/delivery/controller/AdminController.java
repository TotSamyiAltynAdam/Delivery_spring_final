package kz.yeldos.delivery.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value="/admin-panel")
    public String adminPanel(){
        return "admin";
    }
}
