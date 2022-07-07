package asimo.v.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import asimo.v.entities.*;
import asimo.v.entities.enums.TicketType;
import asimo.v.entities.objects.EventObject;
import asimo.v.entities.objects.SessionObject;
import asimo.v.entities.operation.SessionOperation;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import asimo.v.entities.enums.EventStatus;
import asimo.v.repositories.SessionRepository;

@Service
public class SessionService {

    private SessionRepository sessionRepository;
	private TicketService ticketService;

	private LocalizationService localizationService;

	private EventService eventService;


	public SessionService(SessionRepository sessionRepository, TicketService ticketService, LocalizationService localizationService, EventService eventService) {
		this.sessionRepository = sessionRepository;
		this.ticketService = ticketService;
		this.localizationService = localizationService;
		this.eventService = eventService;
	}

	public List<Session> listAllAvailable(){
    	List<Session> findAll = sessionRepository.findAll();
    	
    	return findAll.stream()
    			.filter(s -> s.getSessiosStatus() != EventStatus.FINALIZADO)
    			.collect(Collectors.toList());
    }

    public Session create(SessionOperation sessionOperation, User user) {
		if(user.isAdmin()){
			//validateCreationSession(sessionOperation);
			Event event = eventService.findByEventIdentifier(sessionOperation.getEventIdentifier());
			Localization localization = localizationService.findByLocalizationIdentifier(sessionOperation.getLocalizationIdentifier());

			Session session =  new Session(sessionOperation,localization,event);
			sessionRepository.save(session);
			ticketService.generateSessionTicket(session.getPlace().getNumberOfSeats(),session.getEvent().getEventIdentifier(),session.getPlace().getLocalizationIdentifier(), session.getSessionIdentifier());
			return session;
		}
		throw new RuntimeException("Não foi possível salvar");
    }

	public Session findBySessionIdentifier(String sessionIdentifier){
		Optional<Session> session = this.sessionRepository.findBySessionIdentifier(sessionIdentifier);
		if (session.isPresent()) {
			return session.get();
		}
		throw new RuntimeException("Sessão não encontrada");
	}

	private void validateCreationSession(SessionOperation sessionOperation) {
		Event event = eventService.findByEventIdentifier(sessionOperation.getEventIdentifier());
		Localization localization = localizationService.findByLocalizationIdentifier(sessionOperation.getLocalizationIdentifier());
		if (!sessionRepository.findByPlaceAndEvent(localization,event).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}

		if (!sessionRepository.findByEventAndSessionDate(event,sessionOperation.getSessionDate()).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}
	}
}
