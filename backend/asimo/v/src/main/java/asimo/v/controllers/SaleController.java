package asimo.v.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.services.EventService;
import asimo.v.services.LoginSessionService;
import asimo.v.services.SaleService;
import asimo.v.services.SessionService;
import asimo.v.services.UserService;

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

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<SaleDTO> create(@RequestHeader("token") String token, @RequestHeader String eventidentifier,
//    		@RequestHeader String sessionidentifier, @RequestBody SaleOperation saleOperation){
//        this.loginSessionService.validateToken(token);
//        this.userService.findByToken(token);
//        Session session = this.sessionService.findBySessionIdentifier(sessionidentifier);
//        FilmLegendado event = this.eventService.findByEventIdentifier(eventidentifier);
//
//        return ResponseEntity.ok(this.saleService.makeTheSales(event,session,saleOperation,saleOperation.getTicketOperationList()));
//    }


}
