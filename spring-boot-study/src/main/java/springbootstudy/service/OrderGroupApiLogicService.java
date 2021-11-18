package springbootstudy.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstudy.interfaces.CrudInterface;
import springbootstudy.model.entity.OrderGroup;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.OrderGroupApiRequest;
import springbootstudy.model.network.response.OrderGroupApiResponse;
import springbootstudy.repository.OrderGroupRepository;
import springbootstudy.repository.UserRepository;

@Service
public class OrderGroupApiLogicService implements
    CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest req = request.getData();
        OrderGroup orderGroup = OrderGroup.builder()
            .status(req.getStatus())
            .orderType(req.getOrderType())
            .revAddress(req.getRevAddress())
            .revName(req.getRevName())
            .paymentType(req.getPaymentType())
            .totalPrice(req.getTotalPrice())
            .totalQuantity(req.getTotalQuantity())
            .orderAt(LocalDateTime.now())
            .user(userRepository.getById(req.getUserId()))
            .build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> delete(Long id) {
        return null;
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
        OrderGroupApiResponse res = OrderGroupApiResponse.builder()
            .id(orderGroup.getId())
            .status(orderGroup.getStatus())
            .orderType(orderGroup.getOrderType())
            .revAddress(orderGroup.getRevAddress())
            .revName(orderGroup.getRevName())
            .paymentType(orderGroup.getPaymentType())
            .totalPrice(orderGroup.getTotalPrice())
            .totalQuantity(orderGroup.getTotalQuantity())
            .orderAt(orderGroup.getOrderAt())
            .arrivalDate(orderGroup.getArrivalDate())
            .userId(orderGroup.getUser().getId())
            .build();
        return Header.OK(res);
    }
}
