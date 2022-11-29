package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.eventObjects.ShortFilm;

@Repository
public interface ShortFilmRepository extends JpaRepository<ShortFilm, Long> {

}
