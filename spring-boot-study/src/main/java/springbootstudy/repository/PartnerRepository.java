package springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootstudy.model.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

}
