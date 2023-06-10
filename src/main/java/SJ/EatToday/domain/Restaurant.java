package SJ.EatToday.domain;


import SJ.EatToday.domain.preference.Preference1;
import SJ.EatToday.domain.preference.Preference2;
import SJ.EatToday.domain.preference.Preference3;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
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

    private String address;

    private Preference1 preference1;

    private Preference2 preference2;

    private Preference3 preference3;

    private int season_int;  //1 봄, 2 여름, 3 가을, 4 겨울, 5 계절 영향 없음

    private int weather_int;  //1 폭염, 2 비, 3 한파, 4. 날씨 영향 없음




    private int total_weight;





}
