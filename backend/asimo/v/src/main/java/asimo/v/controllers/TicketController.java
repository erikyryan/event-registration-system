package asimo.v.controllers;

import asimo.v.entities.dto.TicketDTO;
import asimo.v.services.LoginSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Ticket;
import asimo.v.services.TicketService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private LoginSessionService loginSessionService;

    private TicketService ticketService;

    public TicketController(LoginSessionService loginSessionService, TicketService ticketService) {
        this.loginSessionService = loginSessionService;
        this.ticketService = ticketService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllSeats(@RequestHeader("token") String token, @RequestHeader("sessionidentifier") String sessionIdentifier) {
        this.loginSessionService.validateToken(token);
        List<TicketDTO> tickets = ticketService.findAllTicketsBySessionIdentifier(sessionIdentifier)
                .stream().map(Ticket::generateTicketDTO)
                .collect(Collectors.toList()
                );

        return ResponseEntity.ok(tickets);
    }

}
