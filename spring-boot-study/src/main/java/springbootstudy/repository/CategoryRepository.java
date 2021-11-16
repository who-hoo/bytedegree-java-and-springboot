package springbootstudy.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootstudy.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByType(String type);
}
