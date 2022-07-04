package asimo.v.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    Optional<Event> findByNameAndEventDateAndLaunchYear(String name, Date eventDate, Integer launchYear);

    Optional<Event> findByNameAndEventDate(String name, Date eventDate);

    Optional<Event> findByEventIdentifier(String identifier);
}
