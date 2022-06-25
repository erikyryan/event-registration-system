package asimo.v.controllers;

import asimo.v.entities.User;
import asimo.v.services.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(@PathVariable Long id, @RequestHeader("token") String token) {
        return userService.findById(id);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody final User userSession){
    	String token = this.userService.login(userSession);
    	return ResponseEntity.ok(token);
    }
    
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Valid final User userSession){
    	User createdUser = this.userService.create(userSession);
    	return ResponseEntity.ok(createdUser);
    }
    
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> create(@RequestBody User user, @RequestHeader("token") String token){
//        return service.save(user);
//    }
//
//    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user, @RequestHeader("token") String token){
//        return service.update(id,user);
//    }
//
//    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> delete(@PathVariable Long id, @RequestHeader("token") String token){
//        return service.delete(id);
//    }

}
