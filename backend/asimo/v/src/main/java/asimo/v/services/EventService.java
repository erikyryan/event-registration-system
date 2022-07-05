package asimo.v.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asimo.v.entities.Event;
import asimo.v.entities.EventObject;
import asimo.v.entities.User;
import asimo.v.entities.enums.EventStatus;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

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
        }

        throw new RuntimeException("Não foi possível salvar");
    }

    private void validateCreationEvent(EventObject eventObject) {
        if (eventRepository.findByNameAndEventDateAndLaunchYear(eventObject.getName(),eventObject.getEventDate(),eventObject.getLaunchYear()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }

        if (eventRepository.findByNameAndEventDate(eventObject.getName(),eventObject.getEventDate()).isPresent()) {
            throw new InvalidEvent("Evento Inválido");
        }
    }

    public List<Event> listAllAvailable(){
        List<Event> events = eventRepository.findAll();
        return events.stream().filter(e -> e.getEventStatus() != EventStatus.FINALIZADO).collect(Collectors.toList());
    }
}
