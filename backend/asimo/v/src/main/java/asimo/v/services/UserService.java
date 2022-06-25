package asimo.v.services;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import asimo.v.entities.User;
import asimo.v.exceptions.InvalidLogin;
import asimo.v.exceptions.InvalidPasswordException;
import asimo.v.exceptions.UserNotFound;
import asimo.v.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    
    private LoginSessionService loginSessionService;
 
    
    public UserService(UserRepository userRepository, LoginSessionService loginSessionService) {
		this.userRepository = userRepository;
		this.loginSessionService = loginSessionService;
	}

	public ResponseEntity<User> findById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> save(User user){
        userRepository.save(user);
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
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

	public String login(User userS) {
 		validateLogin(userS);
 		return loginSessionService.generateSession(userS);
	}

	public User create(User userParams) {
		validateCreationUser(userParams);
		
		User newUser = new User(userParams);
		newUser.generatePassword(userParams.getPassword());
		
		return null;
	}

	private void validateLogin(User userS) {
		Optional<User> userL = userRepository.findByLogin(userS.getLogin());
		if (!userL.isPresent()) {
			throw new UserNotFound("Usuário não foi encontrado.");
		}
		User currentUser = userL.get();
		String passwordVerify = encryptPassword(userS.getPassword(), currentUser.getSalt());
		
		if (passwordVerify.equals(currentUser.getPassword())) {
			throw new InvalidPasswordException("Senha inválida.");
		}
	}
	
	private void validateCreationUser(User userParams) {
		if (userRepository.findByLogin(userParams.getLogin()).isPresent()) {
			throw new InvalidLogin("Login Inválido");
		}
		
		if (userRepository.findByEmail(userParams.getEmail()).isPresent()) {
			throw new InvalidEmail("Email Inválido");
		}
	}
	public static String generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		
		return DatatypeConverter.printHexBinary(salt).toUpperCase();
	}

	public static String encryptPassword(String password, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(DatatypeConverter.parseByte(salt));
			
			byte[] bytePassword = md.digest(password.getBytes());
			
			return DatatypeConverter.printHexBinary(bytePassword).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException("não deu certo");
		}
	}

}