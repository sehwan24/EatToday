package SJ.EatToday.repository;

import SJ.EatToday.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findById(Long id);

    @Transactional
    @Query(value = "select * from weather limit 1", nativeQuery = true)
    Weather selectWeather();

}
