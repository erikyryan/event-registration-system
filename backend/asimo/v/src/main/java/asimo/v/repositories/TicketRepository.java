package asimo.v.repositories;

import asimo.v.entities.Sale;
import asimo.v.entities.Ticket;
import asimo.v.entities.operation.SaleOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllBySessionIdentifier(String sessionIdentifier);

    Ticket findTicketBySessionIdentifier(String sessionIdentifier);

    List<Ticket> findByProtocol(String protocol);

    Ticket findByTicketIdentifier(String ticketIdentifier);

}
