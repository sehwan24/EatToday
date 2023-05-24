package SJ.EatToday.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Weather_Var {
    private Double temp; // 온도

    private Double rainAmount; // 강수량

    private Double humid; // 습도

    private String lastUpdateTime; // 마지막 갱신 시각 (시간 단위)
}
