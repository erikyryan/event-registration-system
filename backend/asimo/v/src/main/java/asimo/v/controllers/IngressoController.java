package asimo.v.controllers;

import asimo.v.entities.Ingresso;
import asimo.v.entities.Localizacao;
import asimo.v.services.IngressoService;
import asimo.v.services.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService service;

    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingresso> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingresso> save(@RequestBody Ingresso ingresso, @RequestHeader("token") String token){
        return service.save(ingresso);
    }

    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingresso> update(@PathVariable Long id,@RequestBody Ingresso ingresso, @RequestHeader("token") String token){
        return service.update(id,ingresso);
    }

    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingresso> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
