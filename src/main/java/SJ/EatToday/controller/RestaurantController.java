package SJ.EatToday.controller;

import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    public void save(String name, String address) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);

        restaurantService.saveRestaurant(restaurant);
    }





}
