package asimo.v.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import asimo.v.entities.Event;
import asimo.v.entities.Localization;
import asimo.v.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import asimo.v.entities.Ticket;
import asimo.v.repositories.TicketRepository;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Integer seat, String eventIdentifier, String localizationIdentifier, String sessionIdentifier){
        Ticket ticket = new Ticket(seat,eventIdentifier,localizationIdentifier,sessionIdentifier);
        ticketRepository.save(ticket);
    }

    public void generateSessionTicket(Integer numberOfSeats,String eventIdentifier, String localizationIdentifier, String sessionIdentifier){
        for(int seat = 1; seat <= numberOfSeats; seat++){
            this.createTicket(seat,eventIdentifier,localizationIdentifier,sessionIdentifier);
        }
    }

}
