package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.*;
//import SJ.EatToday.controller.dto.RestaurantRequestDto;
//import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.service.RestaurantService;
import SJ.EatToday.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
//@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final WeatherService weatherService;


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
        restaurantService.updateWeatherWeight();
        restaurantService.updatePreferenceWeight();


        RecommendResponseDTO dto = RecommendResponseDTO.builder()
                .name(restaurantService.selectRestaurant())
                .menu(restaurantService.selectRestaurant2())
                .build();
        return ResponseEntity.ok(dto);

    }

}
