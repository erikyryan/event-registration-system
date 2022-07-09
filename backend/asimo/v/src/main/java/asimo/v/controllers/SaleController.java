package asimo.v.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asimo.v.entities.Sale;
import asimo.v.services.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sale> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sale>> findAll(@RequestHeader("token") String token) {
        return service.findAll();
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Sale> save(@RequestBody Sale venda, @RequestHeader("token") String token){
//        return service.save(venda);
//    }
//
//    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Sale> update(@PathVariable Long id,@RequestBody Sale venda, @RequestHeader("token") String token){
//        return service.update(id,venda);
//    }
//
//    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Sale> delete(@PathVariable Long id, @RequestHeader("token") String token){
//        return service.delete(id);
//    }

}
