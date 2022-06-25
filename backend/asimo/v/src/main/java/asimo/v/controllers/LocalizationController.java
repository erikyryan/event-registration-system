package asimo.v.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Localization;
import asimo.v.services.LocalizationService;

@RestController
@RequestMapping("/localization")
public class LocalizationController {

    @Autowired
    private LocalizationService service;

    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localization> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Localization> save(@RequestBody Localization sessao, @RequestHeader("token") String token){
//        return service.save(sessao);
//    }
//
//    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Localization> update(@PathVariable Long id,@RequestBody Localization localizacao, @RequestHeader("token") String token){
//        return service.update(id,localizacao);
//    }
//
//    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Localization> delete(@PathVariable Long id, @RequestHeader("token") String token){
//        return service.delete(id);
//    }
}
