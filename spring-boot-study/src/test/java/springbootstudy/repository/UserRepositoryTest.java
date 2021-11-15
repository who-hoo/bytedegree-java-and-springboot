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
//        User user = new User();
//        user.setAccount("Test01");
//        user.setPassword("Test01");
//        user.setStatus("REGISTERED");
//        user.setEmail("Test01@gmail.com");
//        user.setPhoneNumber("010-1234-5678");
//        user.setRegisteredAt(LocalDateTime.now());
//        user.setCreatedAt(LocalDateTime.now());
//        user.setCreatedBy("admin");
//
//        User newUser = userRepository.save(user);

        User buildUser = User.builder()
            .account("Test02")
            .password("Test02")
            .status("REGISTERED")
            .email("Test02@gmail.com")
            .build();

        buildUser.setAccount("Test03").setPassword("Test03");

        User newUser = userRepository.save(buildUser);

        assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-5678");

        if (user != null) {
            user.getOrderGroupList()
                .forEach(orderGroup -> {
                    System.out.println("-----------주문묶음-----------");
                    System.out.println("수령인 : " + orderGroup.getRevName());
                    System.out.println("수령지 : " + orderGroup.getRevAddress());
                    System.out.println("총금액 : " + orderGroup.getTotalPrice());
                    System.out.println("총수량 : " + orderGroup.getTotalQuantity());
                    System.out.println("-----------주문상세-----------");
                    orderGroup.getOrderDetailList()
                        .forEach(orderDetail -> {
                            System.out.println(
                                "파트너사이름 : " + orderDetail.getItem().getPartner().getName());
                            System.out.println(
                                "파트너사카테고리 : " + orderDetail.getItem().getPartner().getCategory()
                                    .getTitle());
                            System.out.println("주문상품 : " + orderDetail.getItem().getName());
                            System.out.println(
                                "고객센터번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                            System.out.println("주문상태 : " + orderDetail.getStatus());
                            System.out.println("도착예정일 : " + orderDetail.getArrivalDate());

                        });
                });
        }

        assertNotNull(user);
    }
}
