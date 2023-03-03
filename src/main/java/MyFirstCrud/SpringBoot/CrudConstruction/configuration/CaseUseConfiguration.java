package MyFirstCrud.SpringBoot.CrudConstruction.configuration;

import MyFirstCrud.SpringBoot.CrudConstruction.caseuse.GetUser;
import MyFirstCrud.SpringBoot.CrudConstruction.caseuse.GetUserImplement;
import MyFirstCrud.SpringBoot.CrudConstruction.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    //Retorna getUser
    @Bean//Implementacion de la dependencia UserService
    GetUser getUser (UserService userService){
        return new GetUserImplement(userService);
    }


}
