package asimo.v.controllers;

import asimo.v.entities.Event;
import asimo.v.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> findAll( @RequestHeader("token") String token) {
        return service.findAll();
    }
}
