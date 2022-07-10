package asimo.v.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Session;
import asimo.v.entities.dto.SessionDTO;
import asimo.v.services.LoginSessionService;
import asimo.v.services.ReportService;
import asimo.v.services.SessionService;

@RestController
@RequestMapping("/report")
public class ReportController {

	private LoginSessionService loginSessionService;

	private ReportService reportService;

	private SessionService sessionService;
	
	public ReportController(LoginSessionService loginSessionService, ReportService reportService, SessionService sessionService) {
		this.loginSessionService = loginSessionService;
		this.sessionService = sessionService;
		this.reportService = reportService;
	}

	@GetMapping(value = "/session")
	public ResponseEntity<List<SessionDTO>> reportSession(@RequestHeader("token") String token,
			@RequestHeader("sessionIdentifier") String sessionIdentifier){
		this.loginSessionService.validateToken(token);
		List<Session> sessions = this.sessionService.listAllAvailable();
		return ResponseEntity.ok(this.reportService.generateDTO(sessions));
	}
}
