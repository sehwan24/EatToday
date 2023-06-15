package SJ.EatToday.repository;

import SJ.EatToday.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.preference1 = 1", nativeQuery = true)
    void updatePreferenceWeight1_1();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.preference1 = 2", nativeQuery = true)
    void updatePreferenceWeight1_2();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.preference1 = 3", nativeQuery = true)
    void updatePreferenceWeight1_3();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.preference1 = 4", nativeQuery = true)
    void updatePreferenceWeight1_4();



    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.weather_int = 1", nativeQuery = true)
    void updateWeatherWeight1();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.weather_int = 2", nativeQuery = true)
    void updateWeatherWeight2();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.weather_int = 3", nativeQuery = true)
    void updateWeatherWeight3();




    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2", nativeQuery = true)
    void updateSeasonWeight2();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 1", nativeQuery = true)
    void updateSeasonWeight1();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 3", nativeQuery = true)
    void updateSeasonWeight3();

    @Transactional
    @Modifying
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 4", nativeQuery = true)
    void updateSeasonWeight4();

    @Transactional
    @Query(value = "select restaurant_name from restaurant where total_weight = (select max(total_weight) from restaurant) limit 1", nativeQuery = true)
    String selectRestaurant();

    @Transactional
    @Query(value = "select restaurant_address from restaurant where total_weight = (select max(total_weight) from restaurant) limit 1", nativeQuery = true)
    String selectRestaurant2();


    Optional<Restaurant> findById(Long id);



}
