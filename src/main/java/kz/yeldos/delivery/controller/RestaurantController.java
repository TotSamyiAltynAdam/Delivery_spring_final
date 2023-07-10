package kz.yeldos.delivery.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
    @PreAuthorize("hasAnyRole('ROLE_RESTAURANT','ROLE_ADMIN')")
    @GetMapping(value="/restaurant-panel")
    public String restaurantPanel(){
        return "restaurant";
    }
}
