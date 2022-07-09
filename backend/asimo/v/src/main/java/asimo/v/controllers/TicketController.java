package asimo.v.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Ticket;
import asimo.v.entities.dto.TicketDTO;
import asimo.v.services.LoginSessionService;
import asimo.v.services.TicketService;

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
    public ResponseEntity<?> listAllSeats(@RequestHeader("token") String token,
    		@RequestHeader("sessionidentifier") String sessionIdentifier) {
        this.loginSessionService.validateToken(token);
        List<TicketDTO> tickets = ticketService.findAllTicketsBySessionIdentifier(sessionIdentifier)
                .stream().map(Ticket::generateTicketDTO)
                .collect(Collectors.toList()
                );

        return ResponseEntity.ok(tickets);
    }

}
