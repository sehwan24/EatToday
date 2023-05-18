package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Preference1;
import SJ.EatToday.domain.Preference2;
import SJ.EatToday.domain.Preference3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceRequestDto {
    private Preference1 preference1;
    private Preference2 preference2;
    private Preference3 preference3;
}
