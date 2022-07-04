package asimo.v.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping(value = "/available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Session>> availableSession(@RequestHeader("token") String token) {
		this.loginSessionService.validateToken(token);
		return ResponseEntity.ok(sessionService.listAllAvailable());
    }
}
