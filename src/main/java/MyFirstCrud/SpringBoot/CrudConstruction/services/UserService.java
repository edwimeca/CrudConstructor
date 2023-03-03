package MyFirstCrud.SpringBoot.CrudConstruction.services;


import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;

import java.util.List;
public interface UserService {

    List<User> getAllUsers ();

    void save(List<User> users);

}
