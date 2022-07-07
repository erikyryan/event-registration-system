package asimo.v.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Ticket;
import asimo.v.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {


//    @Autowired
//    private TicketService service;

//    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Ticket> findById(@PathVariable Long id, @RequestHeader("token") String token) {
//        return service.findById(id);
//    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Ticket> save(@RequestBody Ticket ingresso, @RequestHeader("token") String token){
//        return service.save(ingresso);
//    }
//
//    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Ticket> update(@PathVariable Long id,@RequestBody Ticket ingresso, @RequestHeader("token") String token){
//        return service.update(id,ingresso);
//    }
//
//    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Ticket> delete(@PathVariable Long id, @RequestHeader("token") String token){
//        return service.delete(id);
//    }

}
