package SJ.EatToday.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Preference {

    @Id @GeneratedValue
    @Column(name = "preference_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;     //member entity와 1대1 매핑

    private int preference_weight;

    public int getPreferenceWeight() {
        return preference_weight;
    }

}
