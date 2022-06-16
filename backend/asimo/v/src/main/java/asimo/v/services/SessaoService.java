package asimo.v.services;

import asimo.v.entities.Sessao;
import asimo.v.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {


    @Autowired
    private SessaoRepository sessaoRepository;

    public ResponseEntity<Sessao> findById(Long id){
        Optional<Sessao> sessao = sessaoRepository.findById(id);

        if(sessao.isPresent()){
            return ResponseEntity.ok().body(sessao.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Sessao> save(Sessao sessao){
        Sessao sessaoSaved = sessaoRepository.save(sessao);
        return ResponseEntity.ok().body(sessaoSaved);
    }

    public ResponseEntity<Sessao> update(Long id, Sessao newSessao){
        Optional<Sessao> oldSessao = sessaoRepository.findById(id);

        if(oldSessao.isPresent()){
            newSessao.setId(oldSessao.get().getId());
            return save(newSessao);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Sessao> delete(Long id){
        Optional<Sessao> sessao = sessaoRepository.findById(id);

        if(sessao.isPresent()){
            sessaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Sessao>> findAll(){
        List<Sessao> sessoes = sessaoRepository.findAll();
        return ResponseEntity.ok().body(sessoes);
    }


}
