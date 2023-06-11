package SJ.EatToday.controller;

import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;


    @PostMapping("/recommend")
    @Transactional
    public void update() {
        restaurantService.updateSeasonWeight();
    }


}
