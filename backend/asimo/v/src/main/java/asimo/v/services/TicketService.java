package asimo.v.services;

import org.springframework.stereotype.Service;

import asimo.v.entities.Ticket;
import asimo.v.repositories.TicketRepository;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Integer seat, String eventIdentifier, String sessionIdentifier){
        Ticket ticket = new Ticket(seat,eventIdentifier,sessionIdentifier);
        ticketRepository.save(ticket);
    }

    public void generateSessionTicket(Integer numberOfSeats,String eventIdentifier, String sessionIdentifier){
        for(int seat = 1; seat <= numberOfSeats; seat++){
            this.createTicket(seat,eventIdentifier,sessionIdentifier);
        }
    }

}
