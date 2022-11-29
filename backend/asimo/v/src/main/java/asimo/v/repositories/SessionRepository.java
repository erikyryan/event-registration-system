package asimo.v.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Session;
import asimo.v.entities.enums.EventStatus;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

//    Optional<Session> findByEventAndSessionStartDate(FilmLegendado event, Date sessionStartDate);

    Optional<Session> findBySessionIdentifier(String sessionIdentifier);

    List<Session> findBySessiosStatus(EventStatus status);
    
//    List<Session> findByEvent(FilmLegendado event);
}
