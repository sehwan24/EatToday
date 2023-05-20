package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
import SJ.EatToday.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preference")
public class PreferenceController {

    private final PreferenceService preferenceService;

    @PostMapping("/input")
    public ResponseEntity<PreferenceResponseDto> input(@RequestBody PreferenceRequestDto preferenceRequestDto) {
        return ResponseEntity.ok(preferenceService.input(preferenceRequestDto));
    }
}
