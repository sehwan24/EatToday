package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {

    private String name;

    public Restaurant toRestaurant() {
        return Restaurant.builder()
                .build();
    }
}
