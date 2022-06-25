package asimo.v.services;

import asimo.v.entities.Event;
import asimo.v.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventoRepository;

    public ResponseEntity<Event> findById(Long id){
        Optional<Event> evento = eventoRepository.findById(id);

        if(evento.isPresent()){
            return ResponseEntity.ok().body(evento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Event> save(Event evento){
        eventoRepository.save(evento);
        return ResponseEntity.ok().body(evento);
    }

    public ResponseEntity<Event> update(Long id, Event newEvento){
        Optional<Event> oldEvento = eventoRepository.findById(id);

        if(oldEvento.isPresent()){
            newEvento.setId(oldEvento.get().getId());
            return save(newEvento);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Event> delete(Long id){
        Optional<Event> user = eventoRepository.findById(id);

        if(user.isPresent()){
            eventoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Event>> findAll(){
        List<Event> eventos = eventoRepository.findAll();
        return ResponseEntity.ok().body(eventos);
    }
}
