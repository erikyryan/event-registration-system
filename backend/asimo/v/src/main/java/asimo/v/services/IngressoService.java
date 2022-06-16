package asimo.v.services;

import asimo.v.entities.Ingresso;
import asimo.v.entities.Venda;
import asimo.v.repositories.IngressoRepository;
import asimo.v.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    public ResponseEntity<Ingresso> findById(Long id){
        Optional<Ingresso> venda = ingressoRepository.findById(id);

        if(venda.isPresent()){
            return ResponseEntity.ok().body(venda.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Ingresso> save(Ingresso ingresso){
        Ingresso ingressoSaved = ingressoRepository.save(ingresso);
        return ResponseEntity.ok().body(ingressoSaved);
    }

    public ResponseEntity<Ingresso> update(Long id, Ingresso newIngresso){
        Optional<Ingresso> oldIngresso = ingressoRepository.findById(id);

        if(oldIngresso.isPresent()){
            newIngresso.setId(oldIngresso.get().getId());
            return save(newIngresso);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Ingresso> delete(Long id){
        Optional<Ingresso> ingresso = ingressoRepository.findById(id);

        if(ingresso.isPresent()){
            ingressoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Ingresso>> findAll(){
        List<Ingresso> ingressos = ingressoRepository.findAll();
        return ResponseEntity.ok().body(ingressos);
    }

}
