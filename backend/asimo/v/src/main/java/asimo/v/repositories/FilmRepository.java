package asimo.v.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.eventObjects.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByNameAndFilmStartDateAndLaunchYear(String name, Date filmStartDate, Integer launchYear);

    Optional<Film> findByNameAndFilmStartDate(String name, Date filmDate);

    Optional<Film> findByFilmIdentifier(String identifier);

    List<Film> findByEventStatus(EventStatus eventStatus);
}
