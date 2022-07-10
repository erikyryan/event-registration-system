package asimo.v.controllers;

import java.util.List;

import asimo.v.entities.Event;
import asimo.v.entities.Session;
import asimo.v.entities.User;
import asimo.v.entities.dto.SaleDTO;
import asimo.v.entities.operation.SaleOperation;
import asimo.v.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import asimo.v.entities.Sale;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private SaleService saleService;

    private LoginSessionService loginSessionService;

    private SessionService sessionService;

    private UserService userService;

    private EventService eventService;

    public SaleController(SaleService saleService, LoginSessionService loginSessionService, SessionService sessionService, UserService userService, EventService eventService) {
        this.saleService = saleService;
        this.loginSessionService = loginSessionService;
        this.sessionService = sessionService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaleDTO> create(@RequestHeader("token") String token,@RequestHeader String eventidentifier ,@RequestHeader String sessionidentifier, @RequestHeader SaleOperation saleOperation){
        this.loginSessionService.validateToken(token);
        this.userService.findByToken(token);
        Session session = this.sessionService.findBySessionIdentifier(sessionidentifier);
        Event event = this.eventService.findByEventIdentifier(eventidentifier);

        return ResponseEntity.ok(this.saleService.makeTheSales(event,session,saleOperation,saleOperation.getTicketOperationList()));
    }


}
