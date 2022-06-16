package asimo.v.controllers;

import asimo.v.entities.User;
import asimo.v.entities.Venda;
import asimo.v.services.UserService;
import asimo.v.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Venda>> findAll(@RequestHeader("token") String token) {
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> save(@RequestBody Venda venda, @RequestHeader("token") String token){
        return service.save(venda);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> update(@PathVariable Long id,@RequestBody Venda venda, @RequestHeader("token") String token){
        return service.update(id,venda);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
