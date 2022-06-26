package asimo.v.repositories;

import asimo.v.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByLogin(String login);

	Optional<User> findByEmail(String email);
}
