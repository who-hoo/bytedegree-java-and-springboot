package springbootstudy.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.User;

public class UserRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("Test01");
        user.setPassword("Test01");
        user.setStatus("REGISTERED");
        user.setEmail("Test01@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        assertNotNull(newUser);
    }

    @Test
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-5678");
        assertNotNull(user);
    }
}
