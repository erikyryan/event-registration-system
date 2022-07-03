package asimo.v.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import asimo.v.entities.Ticket;
import asimo.v.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ingressoRepository;

    public ResponseEntity<Ticket> findById(Long id){
        Optional<Ticket> venda = ingressoRepository.findById(id);

        if(venda.isPresent()){
            return ResponseEntity.ok().body(venda.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Ticket> save(Ticket ingresso){
        Ticket ingressoSaved = ingressoRepository.save(ingresso);
        return ResponseEntity.ok().body(ingressoSaved);
    }

    public ResponseEntity<Ticket> update(Long id, Ticket newIngresso){
        Optional<Ticket> oldIngresso = ingressoRepository.findById(id);

        if(oldIngresso.isPresent()){
            newIngresso.setId(oldIngresso.get().getId());
            return save(newIngresso);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Ticket> delete(Long id){
        Optional<Ticket> ingresso = ingressoRepository.findById(id);

        if(ingresso.isPresent()){
            ingressoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Ticket>> findAll(){
        List<Ticket> ingressos = ingressoRepository.findAll();
        return ResponseEntity.ok().body(ingressos);
    }

}
