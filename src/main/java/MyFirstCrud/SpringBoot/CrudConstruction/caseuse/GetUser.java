package MyFirstCrud.SpringBoot.CrudConstruction.caseuse;


import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;

import java.util.List;

//Esta interface nos entragará la lista de usuarios
public interface GetUser {
    List<User> getAll();
}
