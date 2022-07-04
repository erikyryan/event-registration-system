package asimo.v.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asimo.v.entities.Session;
import asimo.v.entities.enums.EventStatus;
import asimo.v.repositories.SessionRepository;

@Service
public class SessionService {

    private SessionRepository sessaoRepository;

	public SessionService(SessionRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}

    public List<Session> listAllAvailable(){
    	List<Session> findAll = sessaoRepository.findAll();
    	
    	return findAll.stream()
    			.filter(s -> s.getSessiosStatus() != EventStatus.FINALIZADO)
    			.collect(Collectors.toList());
    }
}
