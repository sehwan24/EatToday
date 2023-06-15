package SJ.EatToday.repository;

import SJ.EatToday.domain.Preference;
import SJ.EatToday.domain.Weather;
import SJ.EatToday.domain.preference.Preference1;
import SJ.EatToday.domain.preference.Preference2;
import SJ.EatToday.domain.preference.Preference3;
import SJ.EatToday.domain.preference.Preference4;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    Optional<Preference> findById(Long id);

    @Transactional
    @Query(value = "select preference1 from preference", nativeQuery = true)
    String getPreference1();

    @Transactional
    @Query(value = "select preference2 from preference", nativeQuery = true)
    String getPreference2();

    @Transactional
    @Query(value = "select preference3 from preference", nativeQuery = true)
    String getPreference3();

    @Transactional
    @Query(value = "select preference4 from preference", nativeQuery = true)
    String getPreference4();
}
