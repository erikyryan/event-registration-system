package asimo.v.controllers;

import asimo.v.entities.Event;
import asimo.v.entities.EventObject;
import asimo.v.entities.User;
import asimo.v.entities.UserObject;
import asimo.v.services.EventService;
import asimo.v.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    private UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping(value = "/{identifier}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("identifier") String eventIdentifier, @RequestHeader("token") String token) {
        return ResponseEntity.ok(eventService.findByEventIdentifier(eventIdentifier));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll( @RequestHeader("token") String token) {
        this.userService.findByToken(token);
        return ResponseEntity.ok(eventService.findAll());
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestHeader("token") final String token,@RequestBody final EventObject eventObject){
        User user = userService.findByToken(token);
        Event event = this.eventService.create(eventObject, user);
        return ResponseEntity.ok(event.toString());
    }

}
