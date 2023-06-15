package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Preference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceRequestDto {
    private String preference1;
    private String preference2;
    private String preference3;
    private String preference4;

    public Preference toPreference() {
        System.out.println("preference1 = " + preference1);
        return Preference.builder()
                .preference1(preference1.split("\"")[3])
                .preference2(preference2.split("\"")[3])
                .preference3(preference3.split("\"")[3])
                .preference4(preference4.split("\"")[3])
                .build();
    }
}
