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

    @OneToOne(mappedBy = "weather", fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @Embedded
    private Weather_Var weather_var;

    private int weather_weight;

    public int getWeatherWeight() {
        return weather_weight;
    }

    // 날씨 갱신
    public void updateWeather(Weather_Var weather_var) {
        this.weather_var = weather_var;
    }


}
