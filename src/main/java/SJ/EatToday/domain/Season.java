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

    @OneToOne(mappedBy = "season", fetch = FetchType.LAZY)
    private Restaurant restaurant;

    private int season_weight;



}
