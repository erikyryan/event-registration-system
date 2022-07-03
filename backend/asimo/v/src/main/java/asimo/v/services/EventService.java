package asimo.v.services;

import asimo.v.entities.Event;
import asimo.v.entities.EventObject;
import asimo.v.entities.User;
import asimo.v.entities.UserObject;
import asimo.v.entities.enums.EventStatus;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.exceptions.InvalidLogin;
import asimo.v.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static asimo.v.entities.enums.EventStatus.FINALIZADO;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event findByEventIdentifier(String eventIdentifier){
        Optional<Event> event = this.eventRepository.findByEventIdentifier(eventIdentifier);
        if (event.isPresent()) {
            return event.get();
        }
        throw new RuntimeException("User não encontrado");
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

//    public ResponseEntity<Event> update(Long id, Event newEvento){
//        Optional<Event> oldEvento = eventRepository.findById(id);
//
//        if(oldEvento.isPresent()){
//            newEvento.setId(oldEvento.get().getId());
//            return create(newEvento);
//        }else{
//            return ResponseEntity.badRequest().build();
//        }
//    }

//    public ResponseEntity<Event> delete(Long id){
//        Optional<Event> user = eventRepository.findById(id);
//
//        if(user.isPresent()){
//            eventRepository.deleteById(id);
//            return ResponseEntity.ok().build();
//        }else{
//            return ResponseEntity.badRequest().build();
//        }
//    }
//


    public List<Event> findAll(){
        List<Event> events = eventRepository.findAll();
        return events.stream().filter(e -> e.getEventStatus() != EventStatus.FINALIZADO).collect(Collectors.toList());
    }
}
