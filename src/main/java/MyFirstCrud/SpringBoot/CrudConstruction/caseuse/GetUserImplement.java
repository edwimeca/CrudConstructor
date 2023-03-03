package MyFirstCrud.SpringBoot.CrudConstruction.caseuse;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import MyFirstCrud.SpringBoot.CrudConstruction.services.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {

    //Necesitamos llamar la dependenci User Service
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    //En esat capa vamos a traer la lista de usuario
    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
