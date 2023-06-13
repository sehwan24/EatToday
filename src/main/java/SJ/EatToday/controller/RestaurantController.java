package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.*;
//import SJ.EatToday.controller.dto.RestaurantRequestDto;
//import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    private final RestaurantService restaurantService;


    /*@PostMapping("/recommend")
    @Transactional
    public String update() {
        restaurantService.updateSeasonWeight();
        return "/recommend/new";
    }*/

    /*@GetMapping("/recommend")
    public ResponseEntity<RestaurantResponseDto> recommend(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        return ResponseEntity.ok(restaurantService.recommend(restaurantRequestDto));
    }*/

    @GetMapping("/recommend")
    @Transactional
    public ResponseEntity<RecommendResponseDTO> recommend() {
        restaurantService.updateSeasonWeight();


        RecommendResponseDTO dto = restaurantService.selectRestaurant();
        return ResponseEntity.ok(dto);

    }

}
