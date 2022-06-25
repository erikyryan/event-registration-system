package asimo.v.services;

import asimo.v.entities.Session;
import asimo.v.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessaoRepository;

    public ResponseEntity<Session> findById(Long id){
        Optional<Session> sessao = sessaoRepository.findById(id);

        if(sessao.isPresent()){
            return ResponseEntity.ok().body(sessao.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Session> save(Session sessao){
        Session sessaoSaved = sessaoRepository.save(sessao);
        return ResponseEntity.ok().body(sessaoSaved);
    }

    public ResponseEntity<Session> update(Long id, Session newSessao){
        Optional<Session> oldSessao = sessaoRepository.findById(id);

        if(oldSessao.isPresent()){
            newSessao.setId(oldSessao.get().getId());
            return save(newSessao);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Session> delete(Long id){
        Optional<Session> sessao = sessaoRepository.findById(id);

        if(sessao.isPresent()){
            sessaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Session>> findAll(){
        List<Session> sessoes = sessaoRepository.findAll();
        return ResponseEntity.ok().body(sessoes);
    }
}
