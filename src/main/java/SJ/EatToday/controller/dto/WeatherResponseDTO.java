package SJ.EatToday.controller.dto;

import lombok.Data;

@Data
public class WeatherResponseDTO {
    private WeatherHeaderDTO header;

    private WeatherBodyDTO body;
}
