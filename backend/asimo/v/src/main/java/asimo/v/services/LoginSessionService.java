package asimo.v.services;

import org.springframework.beans.factory.annotation.Autowired;

import asimo.v.entities.LoginSession;
import asimo.v.entities.User;
import asimo.v.repositories.LoginSessionRepository;

public class LoginSessionService {

	@Autowired
	LoginSessionRepository loginSessionRepository;
	
	public String generateSession(User userS) {
		LoginSession userSession = new LoginSession(userS);
		loginSessionRepository.save(userSession);
		
		return userSession.getToken();
	}

}
