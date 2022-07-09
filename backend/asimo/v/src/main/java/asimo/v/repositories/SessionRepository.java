package asimo.v.repositories;

import asimo.v.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Session;

import java.util.Date;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

    Optional<Session> findByEventAndSessionStartDate(Event event, Date sessionStartDate);

    Optional<Session> findBySessionIdentifier(String sessionIdentifier);
    
}
