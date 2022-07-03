package asimo.v.repositories;

import asimo.v.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Long> {
}
