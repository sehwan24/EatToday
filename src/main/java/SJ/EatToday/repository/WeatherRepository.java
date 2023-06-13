package SJ.EatToday.repository;

import SJ.EatToday.domain.Restaurant;
import SJ.EatToday.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
