package SJ.EatToday.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Season {

    @Id @GeneratedValue
    @Column(name = "season_id")
    private Long id;

    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private Restaurant restaurant;

    private int season_weight;

    public int getSeasonWeight() {
        LocalDateTime now = LocalDateTime.now();
        int M = now.getMonthValue();
        if (M==3||M==4||M==5) {

        }
        else if (M==6||M==7||M==8) {

        }
        else if (M==9||M==10||M==11) {

        }
        else {

        }

        return season_weight;
    }

}
