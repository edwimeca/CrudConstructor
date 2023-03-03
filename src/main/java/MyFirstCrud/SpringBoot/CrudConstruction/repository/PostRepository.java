package MyFirstCrud.SpringBoot.CrudConstruction.repository;

import MyFirstCrud.SpringBoot.CrudConstruction.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

}
