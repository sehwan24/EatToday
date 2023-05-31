package SJ.EatToday.service;

import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }


}
