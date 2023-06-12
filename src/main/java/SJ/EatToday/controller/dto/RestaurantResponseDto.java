package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {
    private Long id;

    private String name;

    private String address;


    public static RestaurantResponseDto of(Restaurant restaurant) {
        return new RestaurantResponseDto(restaurant.getId(), restaurant.getName(), restaurant.getAddress());
    }

}
