package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceResponseDto {

    private Preference1 preference1;
    private Preference2 preference2;
    private Preference3 preference3;

    public PreferenceResponseDto(Preference preference) {
        this.preference1 = preference.getPreference1();
        this.preference2 = preference.getPreference2();
        this.preference3 = preference.getPreference3();
    }


}

