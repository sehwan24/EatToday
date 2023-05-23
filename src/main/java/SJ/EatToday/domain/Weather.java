package SJ.EatToday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weather {

    @Id @GeneratedValue
    @Column(name = "weather_id")
    private Long id;

    private Double temp;
    private Double rainAmount;
    private Double humid;
    private String lastUpdateTime;

    private int nx = 61;
    private int ny = 126;


}
