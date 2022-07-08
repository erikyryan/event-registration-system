package asimo.v.repositories;

import asimo.v.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllBySessionIdentifier(String sessionIdentifier);

    Ticket findTicketBySessionIdentifier(String sessionIdentifier);
}
