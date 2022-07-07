package asimo.v.repositories;

import asimo.v.entities.Event;
import asimo.v.entities.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Session;

import java.util.Date;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

    Optional<Session> findByPlaceAndEvent(Localization place, Event event);

    Optional<Session> findByEventAndSessionDate(Event event, Date sessionDate);

    Optional<Session> findBySessionIdentifier(String sessionIdentifier);
}
