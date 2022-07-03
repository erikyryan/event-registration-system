package asimo.v.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import asimo.v.entities.Localization;
import asimo.v.repositories.LocalizacaoRepository;

@Service
public class LocalizationService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public ResponseEntity<Localization> findById(Long id){
        Optional<Localization> localizacao = localizacaoRepository.findById(id);

        if(localizacao.isPresent()){
            return ResponseEntity.ok().body(localizacao.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Localization> save(Localization localizacao){
        Localization localizacaoSaved = localizacaoRepository.save(localizacao);
        return ResponseEntity.ok().body(localizacaoSaved);
    }

    public ResponseEntity<Localization> update(Long id, Localization newLocalizacao){
        Optional<Localization> oldLocalizacao = localizacaoRepository.findById(id);

        if(oldLocalizacao.isPresent()){
            newLocalizacao.setId(oldLocalizacao.get().getId());
            return save(newLocalizacao);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Localization> delete(Long id){
        Optional<Localization> localizacao = localizacaoRepository.findById(id);

        if(localizacao.isPresent()){
            localizacaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Localization>> findAll(){
        List<Localization> localizacaos = localizacaoRepository.findAll();
        return ResponseEntity.ok().body(localizacaos);
    }
}
