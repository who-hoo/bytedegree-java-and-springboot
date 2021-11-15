package springbootstudy.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.OrderDetail;

public class OrderDetailRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setItemId(1L);
        orderDetail.setOrderGroupId(1L);
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("admin");

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        assertNotNull(newOrderDetail);
    }
}
