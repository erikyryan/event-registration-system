package asimo.v.controllers;

import asimo.v.entities.Localizacao;
import asimo.v.entities.Sessao;
import asimo.v.services.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService service;

    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localizacao> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localizacao> save(@RequestBody Localizacao sessao, @RequestHeader("token") String token){
        return service.save(sessao);
    }

    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localizacao> update(@PathVariable Long id,@RequestBody Localizacao localizacao, @RequestHeader("token") String token){
        return service.update(id,localizacao);
    }

    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localizacao> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
