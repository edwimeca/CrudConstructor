package MyFirstCrud.SpringBoot.CrudConstruction;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.Posts;
import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import MyFirstCrud.SpringBoot.CrudConstruction.pojo.properties.UserProperties;
import MyFirstCrud.SpringBoot.CrudConstruction.repository.PostRepository;
import MyFirstCrud.SpringBoot.CrudConstruction.repository.UserRepository;
import MyFirstCrud.SpringBoot.CrudConstruction.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudConstructionApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(this.getClass());

	private UserRepository userRepository;
	private UserProperties userProperties;
	private PostRepository postRepository;
	private UserService userService;

	public CrudConstructionApplication(UserRepository userRepository, UserProperties userProperties, PostRepository postRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userProperties = userProperties;
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudConstructionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("error en el aplicativo");
		saveUsersInDb();

	}
	private void getUsers() {
		List<User> users = userRepository.findAll();
		users.forEach(user -> logger.info(user.toString()));
	}

	//creando base de datos H2
	private void saveUsersInDb() {
		User user1 = new User("John", "john@domain.com", LocalDate.now());
		User user2 = new User("Julie", "julie@domain.com", LocalDate.now());
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.now());
		User user4 = new User("Oscar", "oscar@domain.com", LocalDate.now());
		User user5 = new User("Test1", "Test1@domain.com", LocalDate.now());
		User user6 = new User("Test2", "Test2@domain.com", LocalDate.now());
		User user7 = new User("Test3", "Test3@domain.com", LocalDate.now());
		User user8 = new User("Test4", "Test4@domain.com", LocalDate.now());
		User user9 = new User("Test5", "Test5@domain.com", LocalDate.now());
		User user10 = new User("Test6", "Test6@domain.com", LocalDate.now());
		User user11 = new User("Test7", "Test7@domain.com", LocalDate.now());
		User user12 = new User("Test8", "Test8@domain.com", LocalDate.now());
		User user13 = new User("Test9", "Test9@domain.com", LocalDate.now());
		List<User> list = Arrays.asList(user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13);
		list.stream().forEach(userRepository::save);
		postRepository.save(new Posts("Mi post test1", user12));
		postRepository.save(new Posts("Mi post test2", user13));
		postRepository.save(new Posts("Mi post test3", user13));

	}
}
