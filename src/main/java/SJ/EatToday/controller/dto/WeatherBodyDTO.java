package SJ.EatToday.controller.dto;

import lombok.Data;

@Data
public class WeatherBodyDTO {
    private String dataType;
    private WeatherItemsDTO items;
}
