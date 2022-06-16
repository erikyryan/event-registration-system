package asimo.v.controllers;

import asimo.v.entities.Sessao;
import asimo.v.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService service;

    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sessao> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sessao> save(@RequestBody Sessao sessao, @RequestHeader("token") String token){
        return service.save(sessao);
    }

    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sessao> update(@PathVariable Long id,@RequestBody Sessao sessao, @RequestHeader("token") String token){
        return service.update(id,sessao);
    }

    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sessao> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
