package SJ.EatToday.repository;

import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Restaurant;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    //private final EntityManager em;
    //private final Weather_Var weather_var;

    /*public void updateSeasonWeight() {
        LocalDateTime now = LocalDateTime.now();
        int M = now.getMonthValue();
        if (M==3||M==4||M==5) {

        }
        else if (M==6||M==7||M==8) {
            em.createQuery("update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2");
        }
        else if (M==9||M==10||M==11) {

        }
        else {

        }
    }*/

    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2")
    List<Restaurant> updateSeasonWeight();


    Optional<Restaurant> findById(Long id);



}
