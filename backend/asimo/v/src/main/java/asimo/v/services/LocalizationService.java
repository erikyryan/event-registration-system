package asimo.v.services;

import java.util.List;
import java.util.Optional;

import asimo.v.entities.Event;
import asimo.v.entities.enums.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import asimo.v.entities.Localization;
import asimo.v.repositories.LocalizationRepository;

@Service
public class LocalizationService {

    private LocalizationRepository localizationRepository;

    public LocalizationService(LocalizationRepository localizationRepository) {
        this.localizationRepository = localizationRepository;
    }

    public Localization findByLocalizationIdentifier(String localizationIdentifier){
        Optional<Localization> localization = this.localizationRepository.findByLocalizationIdentifier(localizationIdentifier);
        if (localization.isPresent()) {
            return localization.get();
        }
        throw new RuntimeException("Localização não encontrada");
    }

//    public ResponseEntity<Localization> findById(Long id){
//        Optional<Localization> localizacao = localizationRepository.findById(id);
//
//        if(localizacao.isPresent()){
//            return ResponseEntity.ok().body(localizacao.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    public ResponseEntity<Localization> save(Localization localizacao){
//        Localization localizacaoSaved = localizationRepository.save(localizacao);
//        return ResponseEntity.ok().body(localizacaoSaved);
//    }
//
//    public ResponseEntity<Localization> update(Long id, Localization newLocalization){
//        Optional<Localization> oldLocalizacao = localizationRepository.findById(id);
//
//        if(oldLocalizacao.isPresent()){
//            newLocalization.setId(oldLocalizacao.get().getId());
//            return save(newLocalization);
//        }else{
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
