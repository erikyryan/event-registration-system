package asimo.v.controllers;

import asimo.v.entities.User;
import asimo.v.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user, @RequestHeader("token") String token){
        return service.save(user);
    }

    @PutMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user, @RequestHeader("token") String token){
        return service.update(id,user);
    }

    @DeleteMapping(name = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> delete(@PathVariable Long id, @RequestHeader("token") String token){
        return service.delete(id);
    }

}
