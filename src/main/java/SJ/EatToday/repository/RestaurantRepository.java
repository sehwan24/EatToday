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
    @Query(value = "update Restaurant r set r.total_weight = r.total_weight + 10 where r.season_int = 2", nativeQuery = true)
    void updateSeasonWeight();

    @Transactional
    @Query(value = "select name from restaurant where total_weight = (select max(total_weight) from restaurant) limit 1", nativeQuery = true)
    String selectRestaurant();

    @Transactional
    @Query(value = "select address from restaurant where total_weight = (select max(total_weight) from restaurant) limit 1", nativeQuery = true)
    String selectRestaurant2();


    Optional<Restaurant> findById(Long id);



}
