package asimo.v.repositories;

import asimo.v.entities.Event;
import asimo.v.entities.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization,Long> {
    Optional<Localization> findByLocalizationIdentifier(String identifier);
}
