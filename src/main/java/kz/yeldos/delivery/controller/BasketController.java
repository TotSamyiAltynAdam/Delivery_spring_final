package kz.yeldos.delivery.controller;


import jakarta.servlet.http.HttpSession;
import kz.yeldos.delivery.dto.AdditionalDishDTO;
import kz.yeldos.delivery.dto.BasketDTO;
import kz.yeldos.delivery.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/addBasket")
    public ResponseEntity<String> addDishToBasket(@RequestParam("restaurantId") Long restaurantId,
                                                  @RequestParam("dishId") Long dishId,
                                                  @RequestParam(value = "additionalDishes", required = false) AdditionalDishDTO additionalDishDTO,
                                                  HttpSession session) {
        var basket = (List<BasketDTO>) session.getAttribute(restaurantId.toString());
        if (basket == null) {
            basket = new ArrayList<BasketDTO>();
        }
        BasketDTO basketDTO = basketService.addDish(dishId, additionalDishDTO);
        basket.add(basketDTO);
        session.setAttribute(restaurantId.toString(), basket);
        return ResponseEntity.ok("Item added to the basket.");
    }

    @GetMapping("/getBasket")
    public List<BasketDTO> getItemFromBasket(@RequestParam("restaurantId")  Long restaurantId,
                                             HttpSession session) {
        var restaurantBasket = (List<BasketDTO>) session.getAttribute(restaurantId.toString());
        return restaurantBasket;
    }

}
