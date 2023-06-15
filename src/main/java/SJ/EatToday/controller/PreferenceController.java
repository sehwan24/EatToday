package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
import SJ.EatToday.service.PreferenceService;
import SJ.EatToday.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/preference")
//@CrossOrigin(origins = "http://localhost:3000")
public class PreferenceController {
    private final PreferenceService preferenceService;



    @PostMapping("/input")
    public ResponseEntity<PreferenceResponseDto> input(@RequestBody PreferenceRequestDto preferenceRequestDto) {
        return ResponseEntity.ok(preferenceService.input(preferenceRequestDto));
    }



}
