package asimo.v.repositories;

import asimo.v.entities.Event;
import asimo.v.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    Optional<Event> findByNameAndEventDateAndLaunchYear(String name, Date eventDate, String launchYear);

    Optional<Event> findByNameAndEventDate(String name, Date eventDate);

    Optional<Event> findByEventIdentifier(String identifier);
}
