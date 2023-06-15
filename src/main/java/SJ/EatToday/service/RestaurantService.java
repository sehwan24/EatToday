package SJ.EatToday.service;

import SJ.EatToday.controller.dto.*;
import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.domain.Weather;
import SJ.EatToday.domain.preference.Preference1;
import SJ.EatToday.domain.preference.Preference2;
import SJ.EatToday.domain.preference.Preference3;
import SJ.EatToday.domain.preference.Preference4;
import SJ.EatToday.repository.PreferenceRepository;
import SJ.EatToday.repository.RestaurantRepository;
import SJ.EatToday.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final WeatherRepository weatherRepository;

    private final PreferenceRepository preferenceRepository;


    @Transactional
    public void updatePreferenceWeight() {
        String preference1 = preferenceRepository.getPreference1();
        String preference2 = preferenceRepository.getPreference2();
        String preference3 = preferenceRepository.getPreference3();
        String preference4 = preferenceRepository.getPreference4();

        if (preference1.equals("한식")) {
            restaurantRepository.updatePreferenceWeight1_1();
        }
        else if (preference1.equals("양식")) {
            restaurantRepository.updatePreferenceWeight1_2();
        }
        else if (preference1.equals("중식")) {
            restaurantRepository.updatePreferenceWeight1_3();
        }
        else if (preference1.equals("일식")) {
            restaurantRepository.updatePreferenceWeight1_4();
        }


        if (preference2.equals("매운 음식")) {
            restaurantRepository.updatePreferenceWeight2_1();
        }
        else if (preference2.equals("안 매운 음식")) {
            restaurantRepository.updatePreferenceWeight2_2();
        }

        if (preference3.equals("빵")) {
            restaurantRepository.updatePreferenceWeight3_1();
        }
        else if (preference3.equals("밥")) {
            restaurantRepository.updatePreferenceWeight3_2();
        }
        else if (preference3.equals("면")) {
            restaurantRepository.updatePreferenceWeight3_3();
        }


        if (preference4.equals("차가운 음식")) {
            restaurantRepository.updatePreferenceWeight4_1();
        }
        else if (preference4.equals("뜨거운 음식")) {
            restaurantRepository.updatePreferenceWeight4_2();
        }


    }



    @Transactional
    public void updateWeatherWeight() {
        Weather weather = weatherRepository.selectWeather();

        if (weather.getWeather_var().getTemp() > 25) {
            restaurantRepository.updateWeatherWeight1();
        }

        if (weather.getWeather_var().getRainAmount() > 3) {
            restaurantRepository.updateWeatherWeight2();
        }

        if (weather.getWeather_var().getTemp() < 0) {
            restaurantRepository.updateWeatherWeight3();
        }

    }

    @Transactional
    public void updateSeasonWeight() {
        LocalDateTime now = LocalDateTime.now();
        int M = now.getMonthValue();
        if (M==3||M==4||M==5) {
            restaurantRepository.updateSeasonWeight1();
        }
        else if (M==6||M==7||M==8) {
            restaurantRepository.updateSeasonWeight2();
        }
        else if (M==9||M==10||M==11) {
            restaurantRepository.updateSeasonWeight3();
        }
        else {
            restaurantRepository.updateSeasonWeight4();
        }
    }

    public String selectRestaurant() {
        return restaurantRepository.selectRestaurant();
    }

    public String selectRestaurant2() {
        return restaurantRepository.selectRestaurant2();
    }


}
