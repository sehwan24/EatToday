package SJ.EatToday.repository;

import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Restaurant;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {




    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2", nativeQuery = true)
    void updateSeasonWeight();

    @Transactional
    @Query(value = "select * from restaurant where total_weight = (select max(total_weight) from restaurant)", nativeQuery = true)
    List<Restaurant> selectRestaurant();


    Optional<Restaurant> findById(Long id);



}
