package MyFirstCrud.SpringBoot.CrudConstruction.controller;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import MyFirstCrud.SpringBoot.CrudConstruction.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")//Se agrega la rura para que sea consumido el metodo
public class UserRestController {
    //Se crea capa con los servicios que se van a desplegar CRUD en otro package "caseuse"


    //Se crea una dependencia de user Repositoty desde donde podemos tener acceso a la base de datos
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Metodo que nos entrega la lista de usuarios
    @GetMapping("/")
    List<User> get(){
        return userRepository.findAll();
    }

    //Método que nos va a crear un usuario nuevo
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
    }

    //Metodo para eliminar
    @DeleteMapping("/{id}")
    ResponseEntity deletedUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    //Metodo update
    @PutMapping("/{id}")
        User updateUser(@RequestBody User updateUser, @PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setEmail(updateUser.getEmail());
            user.setBirthDate(updateUser.getBirthDate());
            user.setName(updateUser.getName());
            return userRepository.save(user);
        }).orElseThrow(()-> new UserNotFoundException(id));
    }
}
