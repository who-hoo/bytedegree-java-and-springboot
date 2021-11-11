package springbootstudy.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootstudy.SpringBootStudyApplicationTests;
import springbootstudy.model.entity.OrderDetail;

public class OrderDetailRepositoryTest extends SpringBootStudyApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
//        orderDetail.(7L);
//        orderDetail.setItemId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        System.out.println("newOrderDetail : " + newOrderDetail);
    }

    @Test
    @Transactional
    public void read() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectedOrderDetail -> {
            System.out.println("OrderDetail : " + selectedOrderDetail);
        });
    }

    @Test
    @Transactional
    public void update() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectedOrderDetail -> {
            selectedOrderDetail.setOrderAt(LocalDateTime.now());

            orderDetailRepository.save(selectedOrderDetail);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectedOrderDetail -> {
            orderDetailRepository.delete(selectedOrderDetail);
        });
        Optional<OrderDetail> deletedOrderDetail = orderDetailRepository.findById(1L);
        if (deletedOrderDetail.isPresent()) {
            System.out.println("데이터 삭제 실패 : " + deletedOrderDetail.get());
        } else {
            System.out.println("데이터 삭제 성공");
        }
    }
}
