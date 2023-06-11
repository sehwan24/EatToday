package SJ.EatToday.repository;

import SJ.EatToday.domain.Weather;
import SJ.EatToday.domain.Weather_Var;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {

    private final EntityManager em;
    //private final Weather_Var weather_var;

    public void updateSeasonWeight() {
        LocalDateTime now = LocalDateTime.now();
        int M = now.getMonthValue();
        if (M==3||M==4||M==5) {

        }
        else if (M==6||M==7||M==8) {
            em.createQuery("update restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2");
        }
        else if (M==9||M==10||M==11) {

        }
        else {

        }
    }


    /*public void updateWeatherWeight() {
        if(weather_var.getTemp() > 30) {
            em.createQuery("update restaurant set total_weight = total_weight + 10 where weather_int = 1");
        }
        if(weather_var.getRainAmount() > 3) {
            em.createQuery("update restaurant set total_weight = total_weight + 10 where weather_int = 2");
        }
        if(weather_var.getTemp() < 0) {
            em.createQuery("update restaurant set total_weight = total_weight + 10 where weather_int = 3");
        }
    }*/

}
