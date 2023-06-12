package SJ.EatToday.repository;

import SJ.EatToday.domain.Preference;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    Optional<Preference> findById(Long id);
}
