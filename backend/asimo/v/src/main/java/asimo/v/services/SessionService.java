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

	private EventService eventService;


	public SessionService(SessionRepository sessionRepository, TicketService ticketService, EventService eventService) {
		this.sessionRepository = sessionRepository;
		this.ticketService = ticketService;
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
			validateCreationSession(sessionOperation);
			Event event = eventService.findByEventIdentifier(sessionOperation.getEventIdentifier());

			Session session =  new Session(sessionOperation,event);
			sessionRepository.save(session);
			ticketService.generateSessionTicket(session.getNumberOfSeats(),session.getEvent().getEventIdentifier(), session.getSessionIdentifier());
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
		if (!sessionRepository.findByEventAndSessionDate(event,sessionOperation.getSessionDate()).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}
	}
}
