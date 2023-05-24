package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Weather_Var;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseDTO {

    private Weather_Var weather_var;
}
