package asimo.v.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Session;
import asimo.v.entities.dto.EventBillingDTO;
import asimo.v.entities.dto.SessionDTO;
import asimo.v.services.EventService;
import asimo.v.services.LoginSessionService;
import asimo.v.services.ReportService;
import asimo.v.services.SessionService;

@RestController
@RequestMapping("/report")
public class ReportController {

	private LoginSessionService loginSessionService;

	@Lazy
	private ReportService reportService;

	@Lazy
	private SessionService sessionService;
	
	@Lazy
	private EventService eventService;
	
	public ReportController(LoginSessionService loginSessionService, @Lazy ReportService reportService, @Lazy SessionService sessionService,
			@Lazy EventService eventService) {
		this.loginSessionService = loginSessionService;
		this.sessionService = sessionService;
		this.reportService = reportService;
		this.eventService = eventService;
	}

    @CrossOrigin(origins = "*")
	@GetMapping(value = "/session")
	public ResponseEntity<List<SessionDTO>> reportSession(@RequestHeader("token") String token,
			@RequestHeader("sessionIdentifier") String sessionIdentifier){
		this.loginSessionService.validateToken(token);
		List<Session> sessions = this.sessionService.listAllAvailable();
		return ResponseEntity.ok(this.reportService.generateSessionDTO(sessions));
	}

//    @CrossOrigin(origins = "*")
//	@GetMapping(value = "/event")
//	public ResponseEntity<List<EventDTO>> reportEvent(@RequestHeader("token") String token){
//		this.loginSessionService.validateToken(token);
//		List<FilmLegendado> events = this.eventService.listAllAvailable();
//		return ResponseEntity.ok(this.reportService.generateEventDTO(events));
//	}

    @CrossOrigin(origins = "*")
	@GetMapping(value = "/billing")
	public ResponseEntity<List<EventBillingDTO>> reportEventBilling(@RequestHeader("token") String token,
			@RequestParam(name = "date", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam(name ="sessionIdentifier", required=false) String sessionId){
		this.loginSessionService.validateToken(token);
		List<EventBillingDTO> billing = this.eventService.billingGenerate(date, sessionId);
		return ResponseEntity.ok(billing);
	}
}
