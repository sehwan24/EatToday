package SJ.EatToday.controller;

import SJ.EatToday.controller.dto.PreferenceRequestDto;
import SJ.EatToday.controller.dto.PreferenceResponseDto;
import SJ.EatToday.controller.dto.WeatherResponseDTO;
import SJ.EatToday.domain.Weather;
import SJ.EatToday.domain.Weather_Var;
import SJ.EatToday.service.PreferenceService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
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
