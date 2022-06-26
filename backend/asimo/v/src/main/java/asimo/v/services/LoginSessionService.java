package asimo.v.services;

import org.springframework.beans.factory.annotation.Autowired;

import asimo.v.entities.LoginSession;
import asimo.v.entities.User;
import asimo.v.repositories.LoginSessionRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LoginSessionService {

	private LoginSessionRepository loginSessionRepository;

	public LoginSessionService(@Lazy LoginSessionRepository loginSessionRepository){
		this.loginSessionRepository = loginSessionRepository;
	}


	public String generateSession(User userS) {
		LoginSession userSession = new LoginSession(userS);
		loginSessionRepository.save(userSession);
		
		return userSession.getToken();
	}

}
