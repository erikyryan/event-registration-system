package asimo.v;

import asimo.v.entities.User;
import asimo.v.entities.enums.TipoUsuario;
import asimo.v.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class VApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"Alan Turing","123.123.123-12","M","eae@eae.com","88999999","test","eae", new Date(), TipoUsuario.USER,null);

		userRepository.save(user);
	}
}
