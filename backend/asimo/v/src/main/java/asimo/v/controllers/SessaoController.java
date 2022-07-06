package asimo.v.controllers;

import java.util.List;

import asimo.v.entities.Event;
import asimo.v.entities.objects.EventObject;
import asimo.v.entities.objects.SessionObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import asimo.v.entities.Session;
import asimo.v.services.LoginSessionService;
import asimo.v.services.SessionService;

@RestController
@RequestMapping("/session")
public class SessaoController {

    private SessionService sessionService;

    private LoginSessionService loginSessionService;
    
    public SessaoController(SessionService service, LoginSessionService loginSessionService) {
		this.sessionService = service;
		this.loginSessionService = loginSessionService;
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestHeader("token") final String token,@RequestBody final SessionObject sessionObject){
		this.loginSessionService.validateToken(token);
		Session session = this.sessionService.create(sessionObject, loginSessionService.findUser(token));
		return ResponseEntity.ok(session.toString());
	}

	@GetMapping(value = "/available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Session>> availableSession(@RequestHeader("token") String token) {
		this.loginSessionService.validateToken(token);
		return ResponseEntity.ok(sessionService.listAllAvailable());
    }

	@GetMapping(value = "/public/available",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Session>> availableSession() {
		return ResponseEntity.ok(sessionService.listAllAvailable());
	}
}
