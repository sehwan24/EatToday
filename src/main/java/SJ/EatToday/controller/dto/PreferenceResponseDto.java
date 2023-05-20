package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceResponseDto {
    private Long id;

    public static PreferenceResponseDto of(Preference preference) {
        return new PreferenceResponseDto(preference.getId());
    }



}

