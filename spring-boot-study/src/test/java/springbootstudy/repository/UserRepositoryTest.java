package springbootstudy.repository;

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
    @Transactional
    public void create() {
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectedUser -> System.out.println("User : " + selectedUser));
    }

    @Test
    @Transactional
    public void update() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectedUser -> {
            selectedUser.setAccount("UpdatedUser");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("update method test");

            userRepository.save(selectedUser);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectedUser -> userRepository.delete(selectedUser));
        Optional<User> deletedUser = userRepository.findById(1L);
        if (deletedUser.isPresent()) {
            System.out.println("데이터 삭제 실패 : " + deletedUser.get());
        } else {
            System.out.println("데이터 삭제 성공");
        }
    }
}
