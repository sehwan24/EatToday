package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
//import SJ.EatToday.controller.dto.RestaurantRequestDto;
//import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.controller.dto.RestaurantRequestDto;
import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;


    /*@PostMapping("/recommend")
    @Transactional
    public String update() {
        restaurantService.updateSeasonWeight();
        return "/recommend/new";
    }*/

    @PostMapping("/recommend")
    public ResponseEntity<RestaurantResponseDto> recommend(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        return ResponseEntity.ok(restaurantService.recommend(restaurantRequestDto));
    }

}
