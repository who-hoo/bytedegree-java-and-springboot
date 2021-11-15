package springbootstudy.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.Partner;

public class PartnerRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        Partner partner = new Partner();
        partner.setName("Partner01");
        partner.setStatus("REGISTERED");
        partner.setAddress("서울시 강남구");
        partner.setCallCenter("010-1234-5678");
        partner.setBusinessNumber("1234567890123");
        partner.setCeoName("홍길동");
        partner.setRegisteredAt(LocalDateTime.now());
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("admin");
//        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);
        assertNotNull(partner);
    }
}
