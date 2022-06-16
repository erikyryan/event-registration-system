package asimo.v.controllers;

import asimo.v.entities.Evento;
import asimo.v.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Evento>> findAll( @RequestHeader("token") String token) {
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> save(@RequestBody Evento evento, @RequestHeader("token") String token){
        return service.save(evento);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> update(@PathVariable Long id,@RequestBody Evento evento, @RequestHeader("token") String token){
        return service.update(id,evento);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
