package asimo.v.services;

import java.util.List;
import java.util.stream.Collectors;

import asimo.v.entities.Event;
import asimo.v.entities.User;
import asimo.v.entities.objects.EventObject;
import asimo.v.entities.objects.SessionObject;
import asimo.v.exceptions.InvalidEvent;
import org.springframework.stereotype.Service;

import asimo.v.entities.Session;
import asimo.v.entities.enums.EventStatus;
import asimo.v.repositories.SessionRepository;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

	public SessionService(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

    public List<Session> listAllAvailable(){
    	List<Session> findAll = sessionRepository.findAll();
    	
    	return findAll.stream()
    			.filter(s -> s.getSessiosStatus() != EventStatus.FINALIZADO)
    			.collect(Collectors.toList());
    }

    public Session create(SessionObject sessionObject, User user) {
		if(user.isAdmin()){
			validateCreationSession(sessionObject);
			Session session =  new Session(sessionObject);
			sessionRepository.save(session);
			return session;
		}
		throw new RuntimeException("Não foi possível salvar");
    }

	private void validateCreationSession(SessionObject sessionObject) {
		if (sessionRepository.findByPlaceAndEvent(sessionObject.getPlace(),sessionObject.getEvent()).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}

		if (sessionRepository.findByEventAndSessionDate(sessionObject.getEvent(),sessionObject.getSessionDate()).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}
	}
}
