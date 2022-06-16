package asimo.v.services;

import asimo.v.entities.Evento;
import asimo.v.repositories.EventoRepository;
import asimo.v.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public ResponseEntity<Evento> findById(Long id){
        Optional<Evento> evento = eventoRepository.findById(id);

        if(evento.isPresent()){
            return ResponseEntity.ok().body(evento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Evento> save(Evento evento){
        Evento eventoSaved = eventoRepository.save(evento);
        return ResponseEntity.ok().body(evento);
    }

    public ResponseEntity<Evento> update(Long id, Evento newEvento){
        Optional<Evento> oldEvento = eventoRepository.findById(id);

        if(oldEvento.isPresent()){
            newEvento.setId(oldEvento.get().getId());
            return save(newEvento);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Evento> delete(Long id){
        Optional<Evento> user = eventoRepository.findById(id);

        if(user.isPresent()){
            eventoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
