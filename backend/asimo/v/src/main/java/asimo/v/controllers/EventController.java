package asimo.v.controllers;

import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.dto.EventAvailableDTO;
import asimo.v.facade.EventFacade;
import asimo.v.services.EventService;
import asimo.v.services.LoginSessionService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Lazy
    private EventService eventService;

    private LoginSessionService loginSessionService;
    
    private EventFacade eventFacade;

    public EventController(@Lazy EventService eventService, LoginSessionService loginSessionService, EventFacade eventFacade) {
        this.eventFacade =  eventFacade;
    	this.eventService = eventService;
        this.loginSessionService = loginSessionService;
    }

	@GetMapping(value = "/available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> availableSession(@RequestHeader("token") String token) {
		return ResponseEntity.ok().body("");
    }

    @GetMapping(value = "/{identifier}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByIdentifier(@PathVariable("identifier") String eventIdentifier, @RequestHeader("token") String token) {
        this.loginSessionService.validateToken(token);
        return ResponseEntity.ok().body("");
    }

    @Consumes(value = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestHeader("token") final String token,@RequestBody final Object eventObject){
//        this.loginSessionService.validateToken(token);
        try {
        	this.eventFacade.create(eventObject);
        	return ResponseEntity.ok("Criado");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

    @GetMapping(value = "/public/{identifier}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByIdentifier(@PathVariable("identifier") String eventIdentifier) {
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/public/available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> availableSession() {
    	List<EventAvailableDTO> availabel = this.eventService.listAllAvailable();
//    	ArrayList<String> teste = new ArrayList<String>();
        return ResponseEntity.ok(availabel);
    }
    
}
