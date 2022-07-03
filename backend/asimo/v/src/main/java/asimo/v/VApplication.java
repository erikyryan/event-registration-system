package asimo.v;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VApplication implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User(null,"Alan Turing","123.123.123-12","M","eae@eae.com","88999999","test","eae", new Date(), UserRole.USER,null);
//		userRepository.save(user);
	}
}
