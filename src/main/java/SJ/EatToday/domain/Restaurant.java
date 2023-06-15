package SJ.EatToday.domain;



import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
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

    private String menu;

    private String preference1;

    private String preference2;

    private String preference3;

    private String preference4;

    private int season_int;  //1 봄, 2 여름, 3 가을, 4 겨울, 5 계절 영향 없음

    private int weather_int;  //1 폭염, 2 비, 3 한파, 4. 날씨 영향 없음




    private int total_weight;


    public Restaurant(String name, String address) {
        this.name = name;
        this.menu = address;
    }
}
