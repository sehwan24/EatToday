package SJ.EatToday.domain;

import SJ.EatToday.domain.preference.Preference1;
import SJ.EatToday.domain.preference.Preference2;
import SJ.EatToday.domain.preference.Preference3;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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


    @OneToOne(mappedBy = "preference", fetch = FetchType.LAZY)
    private Restaurant restaurant;

    private int preference_weight;

    @Enumerated(EnumType.STRING)
    private Preference1 preference1;

    @Enumerated(EnumType.STRING)
    private Preference2 preference2;

    @Enumerated(EnumType.STRING)
    private Preference3 preference3;

    public int getPreferenceWeight() {

        return preference_weight;
    }

    @Builder
    public Preference(Preference1 preference1, Preference2 preference2, Preference3 preference3) {
        this.preference1 = preference1;
        this.preference2 = preference2;
        this.preference3 = preference3;
    }

}
