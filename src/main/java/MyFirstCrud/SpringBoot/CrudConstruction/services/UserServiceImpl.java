package MyFirstCrud.SpringBoot.CrudConstruction.services;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;


import MyFirstCrud.SpringBoot.CrudConstruction.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public void save(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: " + user))
                .forEach(user -> userRepository.save(user));

    }
}
