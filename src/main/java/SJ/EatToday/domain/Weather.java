package SJ.EatToday.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Weather {

    @Id @GeneratedValue
    @Column(name = "weather_id")
    private Long id;

    @Embedded
    private Weather_Var weather_var;

    // 날씨 갱신
    public void updateWeather(Weather_Var weather_var) {
        this.weather_var = weather_var;
    }


}
