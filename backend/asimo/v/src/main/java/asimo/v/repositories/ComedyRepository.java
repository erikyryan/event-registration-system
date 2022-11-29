package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.eventObjects.Comedy;

@Repository
public interface ComedyRepository extends JpaRepository<Comedy, Long> {

}
