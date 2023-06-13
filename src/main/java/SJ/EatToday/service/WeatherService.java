package SJ.EatToday.service;

import SJ.EatToday.domain.Weather;
import SJ.EatToday.domain.Weather_Var;
import SJ.EatToday.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Transactional
    public void updateWeather(Weather weather) {

        weatherRepository.save(weather);
    }


}
