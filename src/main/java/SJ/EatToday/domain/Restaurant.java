package SJ.EatToday.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preference_id")
    private Preference preference;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_id")
    private Weather weather;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    private String name;

    private int total_weight;

    public int getTotalWeight() {
        total_weight = preference.getPreferenceWeight() + weather.getWeatherWeight() + season.getSeasonWeight();
        return total_weight;
    }
}
