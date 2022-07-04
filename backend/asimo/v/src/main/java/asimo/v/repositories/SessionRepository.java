package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
	
}
