package springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootstudy.model.entity.OrderGroup;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {

}
