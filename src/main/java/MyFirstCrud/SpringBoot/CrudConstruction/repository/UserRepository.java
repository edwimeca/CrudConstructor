package MyFirstCrud.SpringBoot.CrudConstruction.repository;
import MyFirstCrud.SpringBoot.CrudConstruction.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Interface para llamar los datos de la base de datos
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findAll();
}
