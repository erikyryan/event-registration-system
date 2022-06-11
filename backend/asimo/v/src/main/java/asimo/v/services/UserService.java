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

    public ResponseEntity<User> findById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> save(User user){
        User userSaved = userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> update(Long id, User newUser){
        Optional<User> oldUser = userRepository.findById(id);

        if(oldUser.isPresent()){
            newUser.setId(oldUser.get().getId());
            return save(newUser);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<User> delete(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
