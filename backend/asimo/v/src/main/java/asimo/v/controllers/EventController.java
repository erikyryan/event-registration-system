package asimo.v.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Event;
import asimo.v.services.EventService;
import asimo.v.services.LoginSessionService;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    private LoginSessionService loginSessionService;

    public EventController(EventService eventService, LoginSessionService loginSessionService) {
        this.eventService = eventService;
        this.loginSessionService = loginSessionService;
    }

	@GetMapping(value = "/available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> availableSession(@RequestHeader("token") String token) {
		this.loginSessionService.validateToken(token);
		return ResponseEntity.ok(eventService.listAllAvailable());
    }

}
