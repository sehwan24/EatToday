package SJ.EatToday.service;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
//import SJ.EatToday.controller.dto.RestaurantRequestDto;
//import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.controller.dto.RestaurantRequestDto;
import SJ.EatToday.controller.dto.RestaurantResponseDto;
import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;



    /*@Transactional
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }*/

    /*@Transactional
    public void updateSeasonWeight() {
        restaurantRepository.updateSeasonWeight();
    }*/

    @Transactional(readOnly = true)
    public RestaurantResponseDto findRestaurantInfoById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(RestaurantResponseDto::of)
                .orElseThrow(() -> new RuntimeException("선호도 정보가 없습니다."));
    }

    @Transactional
    public RestaurantResponseDto recommend(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRequestDto.toRestaurant();
        LocalDateTime now = LocalDateTime.now();
        int M = now.getMonthValue();
        if (M==3||M==4||M==5) {

        }
        else if (M==6||M==7||M==8) {
            restaurantRepository.updateSeasonWeight();
        }
        else if (M==9||M==10||M==11) {

        }
        else {

        }
        return RestaurantResponseDto.of(restaurant);
    }

}
