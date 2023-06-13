package SJ.EatToday.service;

import SJ.EatToday.controller.dto.*;
import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;



    @Transactional
    public void updateSeasonWeight() {
        restaurantRepository.updateSeasonWeight();
    }

    public RecommendResponseDTO selectRestaurant() {
        List<Restaurant> restaurants = restaurantRepository.selectRestaurant();
        Restaurant restaurant = restaurants.get(0);
        RecommendResponseDTO dto = RecommendResponseDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .build();
        return dto;
    }


}
