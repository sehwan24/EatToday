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
    public PreferenceResponseDto findPreferenceInfoById(Long preferenceId) {
        return preferenceRepository.findById(preferenceId)
                .map(PreferenceResponseDto::of)
                .orElseThrow(() -> new RuntimeException("선호도 정보가 없습니다."));
    }

    @Transactional
    public PreferenceResponseDto input(PreferenceRequestDto preferenceRequestDto) {
        Preference preference = preferenceRequestDto.toPreference();
        return PreferenceResponseDto.of(preferenceRepository.save(preference));
    }

}
