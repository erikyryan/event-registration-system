package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.eventObjects.Workshop;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

}
