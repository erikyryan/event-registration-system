package asimo.v.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.LoginSession;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSession, Long> {
	Optional<LoginSession> findByUserIdAndlogoutDateNotNull(Long iduser);
	
	Optional<LoginSession> findByToken(String token);
}
