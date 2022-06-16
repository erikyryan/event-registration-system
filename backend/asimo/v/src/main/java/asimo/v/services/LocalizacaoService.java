package asimo.v.services;

import asimo.v.entities.Localizacao;
import asimo.v.entities.Sessao;
import asimo.v.repositories.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public ResponseEntity<Localizacao> findById(Long id){
        Optional<Localizacao> localizacao = localizacaoRepository.findById(id);

        if(localizacao.isPresent()){
            return ResponseEntity.ok().body(localizacao.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Localizacao> save(Localizacao localizacao){
        Localizacao localizacaoSaved = localizacaoRepository.save(localizacao);
        return ResponseEntity.ok().body(localizacaoSaved);
    }

    public ResponseEntity<Localizacao> update(Long id, Localizacao newLocalizacao){
        Optional<Localizacao> oldLocalizacao = localizacaoRepository.findById(id);

        if(oldLocalizacao.isPresent()){
            newLocalizacao.setId(oldLocalizacao.get().getId());
            return save(newLocalizacao);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Localizacao> delete(Long id){
        Optional<Localizacao> localizacao = localizacaoRepository.findById(id);

        if(localizacao.isPresent()){
            localizacaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Localizacao>> findAll(){
        List<Localizacao> localizacaos = localizacaoRepository.findAll();
        return ResponseEntity.ok().body(localizacaos);
    }
}
