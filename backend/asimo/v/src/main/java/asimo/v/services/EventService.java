package asimo.v.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import asimo.v.entities.FilmLegendado;
import asimo.v.entities.Session;
import asimo.v.entities.User;
import asimo.v.entities.dto.EventBillingDTO;
import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.EventType;
import asimo.v.entities.enums.MovieType;
import asimo.v.entities.enums.TheaterType;
import asimo.v.entities.objects.EventObject;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.repositories.FilmRepository;

@Service
public class EventService {

    private FilmRepository eventRepository;

    private SessionService sessionService;
    
    public EventService(FilmRepository eventRepository, @Lazy SessionService sessionService) {
        this.eventRepository = eventRepository;
        this.sessionService = sessionService;
    }

    public FilmLegendado findByEventIdentifier(String eventIdentifier){
        Optional<FilmLegendado> event = this.eventRepository.findByFilmIdentifier(eventIdentifier);
        if (event.isPresent() && event.get().getEventStatus() != EventStatus.FINALIZADO) {
            return event.get();
        }
        throw new RuntimeException("Evento não encontrado");
    }

    public EventsEnum getEventType(Object eventObject, String eventKey) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			EventsEnum eventType = EventsEnum.valueOf(map.get(eventKey));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }
  
    public MovieType getFilmType(Object eventObject, String eventKey) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			MovieType eventType = MovieType.valueOf(map.get(eventKey));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }

    public TheaterType getTheaterType(Object eventObject, String eventKey) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			TheaterType eventType = TheaterType.valueOf(map.get(eventKey));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }
    
    public FilmLegendado create(final EventObject eventObject, final User user){

        if(user.isAdmin()){
            validateCreationEvent(eventObject);
            FilmLegendado event =  new FilmLegendado(eventObject);
            eventRepository.save(event);
            return event;
        }

        throw new RuntimeException("Não foi possível salvar");
    }

    private void validateCreationEvent(EventObject eventObject) {
        if (eventRepository.findByNameAndFilmStartDateAndLaunchYear(eventObject.getName(),eventObject.getEventStartDate(),eventObject.getLaunchYear()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }

        if (eventRepository.findByNameAndFilmStartDate(eventObject.getName(),eventObject.getEventStartDate()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }
    }

	public List<EventBillingDTO> billingGenerate(Date date, String sessionId) {
		List<EventBillingDTO> bilingDTO = new ArrayList<EventBillingDTO>();
		if(date != null && sessionId != null){
			Session session = this.sessionService.findByIdentifierAndDate(date, sessionId);
			Integer amount = this.sessionService.soldAmount(session);
			Long soldAmount = this.sessionService.soldValue(session);
			
			EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
			bilingDTO.add(billing);
			
			return bilingDTO;
		}else if (date != null) {
			List<Session> sessions = this.sessionService.findByDate(date);
			
			for(Session session: sessions) {
				Integer amount = this.sessionService.soldAmount(session);
				Long soldAmount = this.sessionService.soldValue(session);
				
				EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
				
				bilingDTO.add(billing);
			}

			return bilingDTO;
		}else if (sessionId != null) {
			Session session = this.sessionService.findBySessionIdentifier(sessionId);
			Integer amount = this.sessionService.soldAmount(session);
			Long soldAmount = this.sessionService.soldValue(session);
			
			EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
			bilingDTO.add(billing);
			
			return bilingDTO;
		}else{
			List<Session> sessions = this.sessionService.listAllAvailable();
			
			for(Session session: sessions) {
				Integer amount = this.sessionService.soldAmount(session);
				Long soldAmount = this.sessionService.soldValue(session);
				
				EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
				bilingDTO.add(billing);
			}
			return bilingDTO;
		}
	}

	
    public List<FilmLegendado> listAllAvailable(){
        List<FilmLegendado> events = eventRepository.findAll();
        return events.stream()
        		.filter(e -> e.getEventStatus() != EventStatus.FINALIZADO)
        		.collect(Collectors.toList());
    }

    public List<FilmLegendado> listBySessionAndDate(String sessionId, Date date){
    	
    	return null;
    }
	public List<FilmLegendado> listToFinalize() {
        List<FilmLegendado> events = eventRepository.findByEventStatus(EventStatus.EM_ANDAMENTO);
        return events.stream().
                filter(e -> e.getEventEndDate().before(new Date()))
                .collect(Collectors.toList());
	}

	public List<FilmLegendado> listToInitializer() {
        List<FilmLegendado> events = eventRepository.findByEventStatus(EventStatus.AGENDADO);
        return events.stream()
    			.filter(e -> e.getEventStartDate().before(new Date()))
    			.collect(Collectors.toList());
	}
}
