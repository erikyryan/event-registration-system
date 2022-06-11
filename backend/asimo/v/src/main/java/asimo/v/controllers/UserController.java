package asimo.v.controllers;

import asimo.v.entities.User;
import asimo.v.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable Integer id) {
        return service.find(id);
    }

}
