package MyFirstCrud.SpringBoot.CrudConstruction.repository;
import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Interface para llamar los datos de la base de datos, desde esta interface es que se puede acceder a la base de datos
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findAll();
}
