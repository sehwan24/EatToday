package SJ.EatToday.service;

import SJ.EatToday.controller.dto.WeatherApiResponseDTO;
import SJ.EatToday.controller.dto.WeatherItemDTO;
import SJ.EatToday.domain.Weather;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class WeatherService {


    public ResponseEntity<WeatherApiResponseDTO> requestWeatherApi() throws UnsupportedEncodingException, URISyntaxException
    {
        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
        String serviceKey = "OVUJG1Z/hQtUTuUIJ3YD3X5XvkHF83Nc6KrOvraplk1rX5uT2zVwR2u750IZmw1GFdtOOFbnv9oboNp0cYCn4Q==";
        String encodedServiceKey = URLEncoder.encode(serviceKey, "UTF-8");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "JSON", Charset.forName("UTF-8")));

        LocalDateTime now = LocalDateTime.now();
        String yyyyMMdd = now.format(DateTimeFormatter.ofPattern("yyyyMMd"));
        int hour = now.getHour();
        int min = now.getMinute();
        if(min <= 30) { // 해당 시각 발표 전에는 자료가 없음 - 이전시각을 기준으로 해야함
            hour -= 1;
        }
        String hourStr = hour + "00"; // 정시 기준
        String currentChangeTime = now.format(DateTimeFormatter.ofPattern("yy.MM.dd ")) + hour;

        log.info("API 요청 발송 >>> 연월일: {}, 시각: {}", yyyyMMdd, hourStr);

        StringBuilder builder = new StringBuilder(url);
        builder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + encodedServiceKey);
        builder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        builder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8"));
        builder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
        builder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(yyyyMMdd, "UTF-8"));
        builder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode(hourStr, "UTF-8"));
        builder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("61", "UTF-8"));
        builder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("126", "UTF-8"));
        URI uri = new URI(builder.toString());



        ResponseEntity<WeatherApiResponseDTO> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), WeatherApiResponseDTO.class);


        Double temp;
        Double humid;
        Double rainAmount;

        double obsrvalue = response.getBody().getResponse().getBody().getItems().getItem().get(0).getCategory());


        //Weather weather = new Weather(temp, rainAmount, humid)



        return response;
    }
}
