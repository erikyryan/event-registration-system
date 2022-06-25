package asimo.v.controllers;

import asimo.v.entities.Session;
import asimo.v.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessaoController {

    @Autowired
    private SessionService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Session> save(@RequestBody Session sessao, @RequestHeader("token") String token){
//        return service.save(sessao);
//    }
//
//    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Session> update(@PathVariable Long id,@RequestBody Session sessao, @RequestHeader("token") String token){
//        return service.update(id,sessao);
//    }
//
//    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Session> delete(@PathVariable Long id, @RequestHeader("token") String token){
//        return service.delete(id);
//    }
}
