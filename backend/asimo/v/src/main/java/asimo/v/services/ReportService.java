package asimo.v.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import asimo.v.entities.Session;
import asimo.v.entities.dto.SessionDTO;

@Service
public class ReportService {	

	private SessionService sessionService;
	
	public List<SessionDTO> generateDTO(List<Session> sessions) {
		List<SessionDTO> sessionsDTO = new ArrayList<>();
		
		for(Session session: sessions) {
			SessionDTO sDTO = new SessionDTO();
			sDTO.setEventName(session.getEvent().getName());
			sDTO.setAvaliableQuantity(this.sessionService.availableSeats(session));
			sDTO.setSessionId(session.getId().toString());
			sDTO.setSessionStartDate(session.getSessionStartDate());
			
			sessionsDTO.add(sDTO);
		}
		return sessionsDTO;
	}

}
