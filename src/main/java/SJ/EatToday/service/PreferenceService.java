package SJ.EatToday.service;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Preference1;
import SJ.EatToday.domain.Preference3;
import SJ.EatToday.repository.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;

    @Transactional(readOnly = true)
    public PreferenceResponseDto findByPreference1(Preference1 preference1) {
        Preference preference = PreferenceRepository.findByPreference1(preference1);
        return new PreferenceResponseDto(preference);
    }

    @Transactional
    public void savePreference(PreferenceRequestDto preferenceRequestDto) {
        Preference preference = preferenceRequestDto.toPreference();
        preferenceRepository.save(preference);
    }

}
