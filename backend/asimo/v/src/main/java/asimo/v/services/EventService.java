package asimo.v.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asimo.v.entities.Event;
import asimo.v.entities.User;
import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.objects.EventObject;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.repositories.EventRepository;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findByEventIdentifier(String eventIdentifier){
        Optional<Event> event = this.eventRepository.findByEventIdentifier(eventIdentifier);
        if (event.isPresent() && event.get().getEventStatus() != EventStatus.FINALIZADO) {
            return event.get();
        }
        throw new RuntimeException("Evento não encontrado");
    }

    public Event create(final EventObject eventObject, final User user){

        if(user.isAdmin()){
            validateCreationEvent(eventObject);
            Event event =  new Event(eventObject);
            eventRepository.save(event);
            return event;
        }

        throw new RuntimeException("Não foi possível salvar");
    }

    private void validateCreationEvent(EventObject eventObject) {
        if (eventRepository.findByNameAndEventStartDateAndLaunchYear(eventObject.getName(),eventObject.getEventStartDate(),eventObject.getLaunchYear()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }

        if (eventRepository.findByNameAndEventStartDate(eventObject.getName(),eventObject.getEventStartDate()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }
    }

    

    public List<Event> listAllAvailable(){
        List<Event> events = eventRepository.findAll();
        return events.stream()
        		.filter(e -> e.getEventStatus() != EventStatus.FINALIZADO)
        		.collect(Collectors.toList());
    }

	public List<Event> listToFinalize() {
        List<Event> events = eventRepository.findByEventStatus(EventStatus.EM_ANDAMENTO);
        return events.stream().
                filter(e -> e.getEventEndDate().before(new Date()))
                .collect(Collectors.toList());
	}

	public List<Event> listToInitializer() {
        List<Event> events = eventRepository.findByEventStatus(EventStatus.AGENDADO);
        return events.stream()
    			.filter(e -> e.getEventStartDate().before(new Date()))
    			.collect(Collectors.toList());
	}	
}
