package asimo.v.repositories;

import asimo.v.entities.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngressoRepository  extends JpaRepository<Ingresso,Long> {
}
