package MyFirstCrud.SpringBoot.CrudConstruction.controller;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import MyFirstCrud.SpringBoot.CrudConstruction.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")//Se agrega la rura para que sea consumido el metodo
public class UserRestController {
    //Se crea capa con los servicios que se van a desplegar CRUD en otro package "caseuse"
    //Se crea metodo que nos traiga todos los usuarios


    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    List<User> get(){
        return userRepository.findAll();
    }



}
