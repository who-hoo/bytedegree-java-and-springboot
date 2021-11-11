package springbootstudy.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import springbootstudy.model.entity.User;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

}
