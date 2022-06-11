package asimo.v.services;

import asimo.v.entities.User;
import asimo.v.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity find(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok().body(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
