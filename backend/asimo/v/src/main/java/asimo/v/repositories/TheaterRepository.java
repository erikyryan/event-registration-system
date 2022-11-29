package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.eventObjects.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
